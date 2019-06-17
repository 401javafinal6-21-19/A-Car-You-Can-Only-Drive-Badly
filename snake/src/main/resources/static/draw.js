// resource: https://github.com/Mariacristina88/Snake-game

var drawModule = (function () {
  var bodySnake = function (x, y) {
    context.fillStyle = 'yellow';
    context.fillRect(x * snakeSize, y * snakeSize, snakeSize, snakeSize);
    
    context.strokeStyle = 'blue';
    context.strokeRect(x * snakeSize, y * snakeSize, snakeSize, snakeSize);
  }
  var apple = function(x, y) {
    context.fillStyle = 'light-green';
    context.fillRect(x * snakeSize, y * snakeSize, snakeSize, snakeSize);
    
    context.fillStyle = 'green';
    context.fillRect(x * snakeSize + 1, y * snakeSize + 1, snakeSize - 2, snakeSize - 2);
  }
  var scoreText = function() {
    var score_text = "score" + score;
    context.fillStyle = 'maroon';
    context.fillText(score_text, 145, height - 5);
  }
  var drawSnake = function() {
    var length = 4;
    snake = [];
    for (var i = length -1; i >= 0; i--) {
      snake.push({x: i, y: 0});
    }
  } 
  var paint = function() {
    context.fillStyle = 'lightgray';
    context.fillRect(0, 0, width, height);
    context.strokeStyle = 'grey';
    context.strokeRect(0, 0, width, height);

    var snakex = snake[0].x;
    var snakey = snake[0].y;
    if (direction == 'right') {
      snakex++;
    } else if (direction == 'left') {
      snakex--;
    } else if (direction == 'up') {
      snakey--;
    }  else if (direction == 'down') {
      snakey++;
    }
    // change w/ donut. this is how you lose
    if (snakex == -1 || snakex == width/snakeSize || snakey == -1 || snakey == height/snakeSize || checkCollision(snakex, snakey, snake)) {
      context.clearRect(0, 0, width, height);
      gameLoop = clearInterval(gameLoop);
      return;
    }
    if (snakex == food.x && snakey == food.y) {
      var tail = {
        x: snakex,
        y: snakey
      }
      score++;
      createFood();
    } else {
      var tail = snake.pop();
      tail.x = snakex;
      tail.y = snakey;
    }
    snake.unshift(tail);
    for (var i = 0; i < snake.length; i++) {
      bodySnake(snake[i].x, snake[i].y);
    }
    apple(food.x, food.y);
    scoreText();
  }
  var createFood = function() {
    food = {
      x: Math.floor((Math.random() * 30) + 1),
      y: Math.floor((Math.random() * 30) + 1)
    }
    for (var i = 0; i > snake.length; i++) {
      var snakex = snake[i].x;
      var snakey = snake[i].y;
      if (food.x === snakex && food.y === snakey || food.y === snakey && food.x === snakex) {
        food.x = Math.floor((Math.random() * 30) + 1);
        food.y = Math.floor((Math.random() * 30) + 1);
      }
    }
  }
  var checkCollision = function(x, y, array) {
    for (var i = 0; i < array.length; i++) {
      if (array[i].x === x && array[i].y === y) {
        return true;
      } else {
        return false;
      }
    }
  }
  var init = function() {
    direction = 'right';
    drawSnake();
    createFood();
    gameLoop = setInterval(paint, 80);
  }
  return {
    init: init
  };
}());