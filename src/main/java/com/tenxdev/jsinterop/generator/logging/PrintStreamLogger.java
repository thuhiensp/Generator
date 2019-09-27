/*
 * Copyright 2017 Abed Tony BenBrahim <tony.benrahim@10xdev.com>
 *     and Gwt-JElement project contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.tenxdev.jsinterop.generator.logging;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class PrintStreamLogger implements Logger {
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss.SSS Z");
    private final PrintStream printStream;
    private final PrintStream errorStream;
    private int logLevel;

    public PrintStreamLogger(PrintStream printStream, PrintStream errorStream) {
        this.printStream = printStream;
        this.errorStream = errorStream;
    }

    @Override
    public void reportError(String error) {
        errorStream.println(error);
        errorStream.flush();
    }

    @Override
    public void formatError(String format, Object... args) {
        errorStream.println(timestamp() + " ERROR " + String.format(format, args));
        errorStream.flush();
    }

    @Override
    public int getLogLevel() {
        return logLevel;
    }

    @Override
    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void info(Supplier<String> messageSupplier) {
        if (logLevel >= Logger.LEVEL_INFO) {
            printStream.println(timestamp() + " INFO  " + messageSupplier.get());
            printStream.flush();
        }
    }

    @Override
    public void debug(Supplier<String> messageSupplier) {
        if (logLevel >= Logger.LEVEL_DEBUG) {
            printStream.println(timestamp() + " DEBUG \t" + messageSupplier.get());
            printStream.flush();
        }
    }

    @Override
    public void rawOutput(Supplier<String> messageSupplier) {
        if (logLevel >= Logger.LEVEL_INFO) {
            printStream.println(messageSupplier.get());
            printStream.flush();
        }
    }

    private String timestamp() {
        return dateFormat.format(new Date());
    }


}
