/**
 * Created by HaiNNT on 10/21/2014.
 */

var competitorSpeed;
var competitorTime;
var checkedParagraph = "";
var uncheckedParagraph;
var durationTime = 0;
var freeTime = 3;
var countFreeTime = 3;
var countDownFreeTimeInterval;
var length;
var gameFreeTimeOut;
var competitorInterval;
var countTimeInterval;
var inputText;

/*
 Start game when user click ready button at game page
 */
function startGame() {
    $(document).ready(function () {
        inputText = $("#input-text");
        uncheckedParagraph = $("#unChecked-paragraph").text().split(" ");
        length = $("#unChecked-paragraph").text().length;
        competitorSpeed = parseInt($("#competitor-speed").text());
    });
    competitorTime = (length / competitorSpeed) * 60;
    //gameFreeTimeOut = setTimeout(beginGame, freeTime*1000);
    countDownFreeTimeInterval = setInterval(countDown, 1000);
}

/*
 Begin count typing time
 */
function beginGame() {
    //gameInterval = setInterval(game, 1);
    game();
    competitorInterval = setInterval(playCompetitor, 10);
    countTimeInterval = setInterval(countTime, 100);
}

/*
 Main game function
 */
function game() {
    $(document).keydown(function (event) {
        if (uncheckedParagraph != "") {
            //var char = uncheckedParagraph[0] == " "? "SPACE" : uncheckedParagraph[0] == "\n" ? "ENTER" : "KEY_" + uncheckedParagraph[0].toUpperCase();
            if (event.which == 32) {
                if (inputText.val().trim() == uncheckedParagraph[0]) {
                    checkedParagraph += uncheckedParagraph[0] + " ";
                    bindContent();
                    uncheckedParagraph.splice(0,1);
                    inputText.val("");
                }
                else {
                    console.log("wrong!");
                }
            }
            console.log(event.which);
        } else {
        }
    });
}

/*
 Bind article content
 */
function bindContent() {
    $("#unChecked-paragraph").text($("#unChecked-paragraph").text().slice(uncheckedParagraph[0].length + 1));
    $("#checked-paragraph").text(checkedParagraph);
}

/*
 Call when user complete article or click 'Give up' button
 */
function stopGame() {
    clearInterval(countTimeInterval);
    clearInterval(competitorInterval);
    $("#txtSpeed").val(checkedParagraph.length / (durationTime / 10) * 60);
    alert(checkedParagraph.length / (durationTime / 10) * 60);
}

function countDown() {
    $("#count-down").text(countFreeTime);
    countFreeTime -= 1;
    if (countFreeTime < 0) {
        $("#article-content-div").removeClass("hidden");
        $("#count-down").addClass("hidden");
        clearInterval(countDownFreeTimeInterval);
        beginGame();
    }
}

function countTime() {
    durationTime += 1;
}

function playCompetitor() {
    var competitorProgress = $("#competitor-progress progress");
    var youProgress = $("#you-progress progress");
    var cVal = parseFloat(competitorProgress.val());
    var yVal = parseFloat(youProgress.val());
    if (cVal == 100 || yVal == 100) {
        stopGame();
    } else {
        competitorProgress.val(100 / (competitorTime * 100) + cVal);
        youProgress.val(checkedParagraph.length / length * 100);
    }

}





