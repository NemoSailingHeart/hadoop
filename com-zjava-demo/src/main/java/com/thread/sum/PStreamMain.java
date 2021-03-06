package com.thread.sum;

import com.thread.bean.Msg;

/**
 * 并行流水线
 * 计算（ B + C ）* B / 2
 */
public class PStreamMain
{
    public static void main(String[] args)
    {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.bq.add(msg);
            }
        }

    }
}
