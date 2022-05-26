package simulation.parserXML;

import simulation.reseau.Chemin;
import simulation.reseau.Reseau;
import simulation.usine.Entrepot;
import simulation.usine.Usine;
import simulation.usine.UsineProduction;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class ParserXML {

    public Reseau parser(String filename) {
        Reseau reseau = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            // optional, but recommended
            doc.getDocumentElement().normalize();

            Element configuration = doc.getDocumentElement();

            // récupération des différents types d'usine sous forme de meta usine
            Element metadonnees = (Element) configuration.getElementsByTagName("metadonnees").item(0);
            HashMap<String, MetaUsine> meta_usines = parserMeta(metadonnees);

            // récupération du réseau en fonction en fonction de la configuration
            Element simulation = (Element) configuration.getElementsByTagName("simulation").item(0);
            reseau = parserSimulation(simulation, meta_usines);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Parsing correct");
        return reseau;
    }

    private HashMap<String, MetaUsine> parserMeta(Element metadonnees) {
        HashMap<String, MetaUsine> meta_usines = new HashMap<>();

        NodeList usines = metadonnees.getElementsByTagName("usine");
        for (int i = 0; i < usines.getLength(); i++) {

            MetaUsine meta_usine = new MetaUsine();
            Element usine = (Element) usines.item(i);

            // récupération du type d'usine
            meta_usine.setType(usine.getAttribute("type"));

            // récupération des chemins d'accès vers les icones
            Element icones = (Element) usine.getElementsByTagName("icones").item(0);
            NodeList paths = icones.getElementsByTagName("icone");

            for (int j = 0; j < paths.getLength(); j++) {
                Element icone = (Element) paths.item(j);
                meta_usine.addIcone(icone.getAttribute("path"));
            }

            // vérification si l'usine est un entrepot
            NodeList entrees = usine.getElementsByTagName("entree");
            if (entrees.getLength() > 0) {
                Element entree = (Element) entrees.item(0);
                if (entree.hasAttribute("capacite")) {
                    meta_usine.setAsEntrepot();
                }
            }

            meta_usines.put(meta_usine.getType(), meta_usine);
        }

        return meta_usines;
    }

    private Reseau parserSimulation(Element simulation, HashMap<String, MetaUsine> meta_usines) {
        Reseau reseau = new Reseau();
        HashMap<Integer, Usine> id_map = new HashMap<>();

        // instanciation des usines
        NodeList usines = simulation.getElementsByTagName("usine");
        for (int i = 0; i < usines.getLength(); i++) {
            Element usine_element = (Element) usines.item(i);
            int id = Integer.parseInt(usine_element.getAttribute("id"));
            String type = usine_element.getAttribute("type");
            int x = Integer.parseInt(usine_element.getAttribute("x"));
            int y = Integer.parseInt(usine_element.getAttribute("y"));

            Usine usine;
            if (meta_usines.get(type).isEntrepot()) {
                usine = new Entrepot(id, type, new int[] { x, y }, meta_usines.get(type).getIcones_path());
            } else {
                usine = new UsineProduction(id, type, new int[] { x, y }, meta_usines.get(type).getIcones_path());
            }

            id_map.put(id, usine);
            reseau.ajouterUsine(usine);

        }

        // création des chemins

        Element chemins_element = (Element) simulation.getElementsByTagName("chemins").item(0);
        NodeList chemins = chemins_element.getElementsByTagName("chemin");
        for (int i = 0; i < chemins.getLength(); i++) {
            Element chemin_element = (Element) chemins.item(i);
            int id_depart = Integer.parseInt(chemin_element.getAttribute("de"));
            int id_arrivee = Integer.parseInt(chemin_element.getAttribute("vers"));

            Chemin chemin = new Chemin(id_map.get(id_depart), id_map.get(id_arrivee));
            reseau.ajouterChemin(chemin);
        }

        return reseau;
    }

}
