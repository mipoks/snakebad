package ru.realsanya.snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainActivity extends Game {
    SpriteBatch batch;
    Snake snake;
    Food food;


    public void create() {
        batch = new SpriteBatch();
        snake = new Snake();
        food = new Food();
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        food.render(batch);
        snake.render(batch);
        batch.end();

        if (check()) {
            food.change();
            Snake.plusDeep();
        }
    }

    public boolean check() {
        if ((snake.x <= food.x) &&
                (snake.y <= food.y &&
                        ((snake.x + 32) >= (food.x + 16))
                        && ((snake.y + 32) >= (food.y + 16)))) {
            return true;
        }
        return false;
    }

    public void dispose() {
        batch.dispose();
        snake.dispose();
        food.dispose();
    }
}
