/*
 * Copyright (c) 2011, DataLite. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package cz.datalite.zk.annotation.processor;

import cz.datalite.zk.annotation.invoke.Invoke;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Interface which processors what produce MethodInvoker or similar have to
 * implement. The main method says that the result of on annotation doent
 * have to be only one method invoker, it can be more.
 *
 * @author Karel Čemus <cemus@datalite.cz>
 */
public interface Initializer {

    /**
     * Method processing method and produces list of Method invokers.
     * List can be also empty but NULL value is not allowed.
     * @param method targeted method
     * @return list of method invokers
     */
    List<Invoke> process( Method method );
}
