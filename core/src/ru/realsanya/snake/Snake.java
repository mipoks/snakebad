package ru.realsanya.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class Snake {
    private static int deep = 1;
    public static int getDeep() {
        return deep;
    }
    public static void plusDeep() {
        deep++;
    }
    int old = 1;
    boolean was = false;
    int x = 45;
    int y = 45;
    int speed = 2;
    char last = 'D';
    ArrayDeque <Integer> xqueue = new ArrayDeque<Integer>();
    ArrayDeque <Integer> yqueue = new ArrayDeque<Integer>();
    Texture imgSnake;

    public void dodraw (int deep1, int deepnum, SpriteBatch batch) {
        int oldx = -9999, oldy = -9999, xnow, ynow;
        while (deepnum < deep1) {
            if ((oldx != -9999) && (oldy != -9999)) {
                xnow = oldx;
                ynow = oldy;
                oldx = xqueue.pollFirst();
                oldy = yqueue.pollFirst();
            }
            else {
                xnow = xqueue.pollFirst();
                ynow = yqueue.pollFirst();
                oldx = xnow;
                oldy = ynow;
            }
            System.out.println(xnow + " " + ynow + " " + xqueue.size());
           // System.out.println(ynow);
            batch.draw(imgSnake, xnow, ynow, 32,32);
            deepnum++;
            xqueue.addLast(xnow);
            yqueue.addLast(ynow);
        }
    }

    public Snake() {
        imgSnake = new Texture(Gdx.files.internal("body.png"));
    }

    public void render(SpriteBatch batch) {
//        if (xqueue.isEmpty() && was ==  false) {
//            was = true;
//            xqueue.push(45);
//            yqueue.push(45);
//        }
        int deep2 = Snake.getDeep();
        if (old != deep2) {
            xqueue.addFirst(x);
            yqueue.addFirst(y);
            System.out.println("WEADDED " + xqueue.size() + " " + yqueue.size());
        }
        old = deep2;

        System.out.println(deep);

        if (last == 'D') {
            x += speed;
        }
        if (last == 'A') {
            x -= speed;
        }
        if (last == 'W') {
            y += speed;
        }
        if (last == 'S') {
            y -= speed;
        }
        xqueue.addFirst(x);
        yqueue.addFirst(y);
        dodraw(deep2, 0, batch);
        xqueue.pop();
        yqueue.pop();

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (last != 'A')
            last = 'D';
        }
        else
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (last != 'D')
            last = 'A';
        }
        else
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (last != 'S')
            last = 'W';
        }
        else
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (last != 'W')
            last = 'S';
        }
    }

    public void dispose() {
        imgSnake.dispose();
    }
}
