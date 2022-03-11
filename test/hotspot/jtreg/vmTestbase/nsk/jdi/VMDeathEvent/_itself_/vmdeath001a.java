/*
 * Copyright (c) 2001, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package nsk.jdi.VMDeathEvent._itself_;

import nsk.share.*;
import nsk.share.jpda.*;
import nsk.share.jdi.*;


// This class is the debugged application in the test

public class vmdeath001a {
    static final int PASSED = 0;
    static final int FAILED = 2;
    static final int JCK_STATUS_BASE = 95;
    static final String COMMAND_READY = "ready";
    static final String COMMAND_QUIT = "quit";

    public static void main(String args[]) {
        vmdeath001a _vmdeath001a = new vmdeath001a();
        System.exit(JCK_STATUS_BASE + _vmdeath001a.communication(args));
    }

    int communication( String args[]) {
        ArgumentHandler argHandler = new ArgumentHandler(args);
        IOPipe pipe = argHandler.createDebugeeIOPipe();

        pipe.println(COMMAND_READY);
        String command = pipe.readln();
        if (!command.equals(COMMAND_QUIT)) {
              System.err.println("TEST BUG: Debugee: unknown command: " +
                   command);
              return FAILED;
        }
        return PASSED;
    }
}
