/*
 * Copyright 2011-2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.shell.core.CommandConstants.SYSTEM_COMMAND;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.AbstractShellTest;
import org.springframework.shell.CommandResult;


/**
 * System command test.
 * 
 * @author David Winterfeldt
 */
public class SystemCommandTest extends AbstractShellTest {
    
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testSystemCommand() {
        String command = SYSTEM_COMMAND + " ";
        
        if (SystemUtils.IS_OS_WINDOWS) {
            command += "dir";
        } else {
            command += "ls";
        }

        CommandResult cr = shell.exec(command);
        
        String outputText = cr.getOutputText();

        // no real operation, just check that the command was processed in the shell
        assertNotNull("Output text for '" + command + "' command shouldn't be null.", outputText);
        assertTrue(outputText.contains(command));
        
        // FIXME: commandOutput result is 'VOID', where is result
        
        verifyShellOperational();
    }
    
}