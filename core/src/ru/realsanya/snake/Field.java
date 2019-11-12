package ru.realsanya.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Point;


public class Field {
    Texture border;
    SpriteBatch batch;
    char ch = ' ';
    int x = 320;
    int y = 640;

    Field() {
        border = new Texture(Gdx.files.internal("check-box-empty.png"));
        batch = new SpriteBatch();
    }

    //
//    public void render(float delta) {
//        DrawHorizontal(x, 0);
//        DrawHorizontal(x, y);
//        DrawVertical(0, y);
//        DrawVertical(x, y);
//    }
    public void render(int x, int y, char ch) {
        this.ch = ch;
        DrawHorizontal(x, 0);
        DrawHorizontal(x, y);
        DrawVertical(0, y);
        DrawVertical(x, y);
    }

    private void DrawHorizontal(int x, int y) {
        batch.begin();
        for (int i = 0; i < x; i++) {
            batch.draw(border, i, y, border.getWidth(), border.getHeight());
        }
        batch.end();
    }

    private void DrawVertical(int x, int y) {
        batch.begin();
        for (int i = 0; i < y; i++) {
            batch.draw(border, x, i, border.getWidth(), border.getHeight());
        }
        batch.end();
    }
//    private MainActivity game;
//    private int width = 320;
//    private int height = 640;
//    int x = 320;
//    int y = 640;
//    OrthographicCamera camera = new OrthographicCamera(width, height);
//    Viewport viewport;
//
//
//    public Field() {
//        camera.setToOrtho(false, width, height);
//        viewport = new FitViewport(width, height, camera);
//        viewport.apply();
//    }
//
//    public void render(int x, int y, char ch) {
//        this.ch = ch;
//        DrawHorizontal(x, 0);
//        DrawHorizontal(x, y);
//        DrawVertical(0, y);
//        DrawVertical(x, y);
//    }
//
//    private void DrawHorizontal(int x, int y) {
//        batch.begin();
//        for (int i = 0; i < x; i++) {
//            batch.draw(border, i, y, border.getWidth(), border.getHeight());
//        }
//        batch.end();
//    }
//
//
//    private void DrawVertical(int x, int y) {
//        batch.begin();
//        for (int i = 0; i < y; i++) {
//            batch.draw(border, x, i, border.getWidth(), border.getHeight());
//        }
//        batch.end();
//    }


}
