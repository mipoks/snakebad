package ru.realsanya.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Food {
    int x;
    int y;
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    Texture imgFood;

    Food() {
        imgFood = new Texture(Gdx.files.internal("food.png"));
    }

    public void render(SpriteBatch batch) {
        batch.draw(imgFood, x, y, 16, 16);
    }

    public void change() {
        x = (int) (Math.random() * width);
        y = (int) (Math.random() * height);

    }

    public void dispose() {
        imgFood.dispose();
    }
}
