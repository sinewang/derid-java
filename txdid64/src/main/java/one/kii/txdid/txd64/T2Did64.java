/*
The MIT License (MIT)

Copyright (c) 2016 Yanjiong Wang(https://yanjiong.wang)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package one.kii.txdid.txd64;

/**
 * Created by WangYanJiong on 7/29/16.
 */
public class T2Did64 extends AbstractTxDid64 {

    private static final int FIELD_T = 1;

    private static final int FIELD_YY = 2;

    private static final int FIELD_MM = 3;

    private static final int FIELD_DD = 4;

    private static final int FIELD_HH = 5;

    private static final int FIELD_mm = 6;

    private static final int FIELD_SS = 7;

    private static final int FIELD_SYS = 8;

    private static final int FIELD_INS = 9;

    private static final int FIELD_SER = 10;

    private static final String PREFIX = "B";

    T2Did64(long id) {
        this.id = id;
    }

    synchronized void parse() {
        if (array != null) {
            return;
        }
        array = TxDid64Parser.t2did2Array(id);

        StringBuffer buffer = new StringBuffer();

        buffer.append(PREFIX);
        buffer.append(getType());
        buffer.append(DELIMITER);
        buffer.append(getYear());
        buffer.append(TxDid64Parser.padding(getMonth()));
        buffer.append(TxDid64Parser.padding(getDate()));
        buffer.append(DOT);
        buffer.append(TxDid64Parser.padding(getHour()));
        buffer.append(TxDid64Parser.padding(getMinute()));
        buffer.append(TxDid64Parser.padding(getSecond()));
        buffer.append(DELIMITER);
        buffer.append(getSystem());
        buffer.append(DOT);
        buffer.append(getInstance());
        buffer.append(DOT);
        buffer.append(getSerial());
        stringValue = buffer.toString();
    }

    public short getYear() {
        if (array == null) {
            parse();
        }
        return array[FIELD_YY];
    }

    public short getMonth() {
        if (array == null) {
            parse();
        }
        return array[FIELD_MM];
    }

    public short getDate() {
        if (array == null) {
            parse();
        }
        return array[FIELD_DD];
    }

    public short getHour() {
        if (array == null) {
            parse();
        }
        return array[FIELD_HH];
    }

    public short getMinute() {
        if (array == null) {
            parse();
        }
        return array[FIELD_mm];
    }

    public short getSecond() {
        if (array == null) {
            parse();
        }
        return array[FIELD_SS];
    }

    public short getType() {
        if (array == null) {
            parse();
        }
        return array[FIELD_T];
    }

    public short getSystem() {
        if (array == null) {
            parse();
        }
        return array[FIELD_SYS];
    }

    public short getInstance() {
        if (array == null) {
            parse();
        }
        return array[FIELD_INS];
    }

    public short getSerial() {
        if (array == null) {
            parse();
        }
        return array[FIELD_SER];
    }

    public enum Tid64Type {

        I4096S2048,

        I2048S2048,

        I1024S2048,

        I512S2048,

        I512S1024,

        I256S1024,

        I128S1024,

        I128S512
    }

}
