/* Observer.java -- an object that will be informed of changes in an Observable
   Copyright (C) 1998, 1999, 2001, 2002, 2005  Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version. */

package simulation.observer;

/**
 * Interface that is implemented when a class wants to be informed of changes
 * in Observable objects.
 *
 * @author Warren Levy (warrenl@cygnus.com)
 * @see Observable
 * @status updated to 1.4
 */
public interface Observer {
    /**
     * This method is called whenever the observable object changes, and has
     * called <code>notifyObservers</code>. The Observable object can pass
     * arbitrary information in the second parameter.
     *
     * @param observable the Observable object that changed
     * @param arg        arbitrary information, usually relating to the change
     */
    void update(Observable observable, Object arg);
}