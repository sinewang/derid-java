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
package wang.yanjiong.derid64;

import org.junit.Test;

import static wang.yanjiong.derid64.derid64.Derid64Parser.fromHexString;
import static wang.yanjiong.derid64.derid64.Rid64.Tid64Type.I128S512;

/**
 * Created by WangYanJiong on 7/26/16.
 */

public class Rid64Test {

    @Test
    public void TestGenerator() {
        Rid64Generator generator = new Rid64Generator(I128S512, 12, 12);
        Rid64 tid64 = generator.next();

        String[] s = tid64.toString().split("-");


        long now = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            Rid64 id = generator.next();
            System.out.println(id.value() + ", " + id + ", " + id.decoded() + ", " + fromHexString(id.toString()));
        }
        System.out.println(System.currentTimeMillis() - now);

    }

}