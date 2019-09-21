package xyzz.shubhamsingh.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons=new Button[3][3];
    private boolean player1Turn=true;
    private int roundCounts=0;
    private int player1points=0;
    private int player2points=0;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private Button reset_button;
    int i,j;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1=(TextView)findViewById(R.id.text_view_player1);
        textViewPlayer2=(TextView)findViewById(R.id.text_view_player2);
        reset_button=(Button)findViewById(R.id.button_reset);
        reset_button.setOnClickListener(new View.OnClickListener() {
                                            /**
                                             * Called when a view has been clicked.
                                             *
                                             * @param v The view that was clicked.
                                             */
                                            @Override
                                            public void onClick(View v) {
                                                resetGame();
                                            }
                                        });

        buttons[0][0]=(Button)findViewById(R.id.button_00);
        buttons[0][1]=(Button)findViewById(R.id.button_01);
        buttons[0][2]=(Button)findViewById(R.id.button_02);
        buttons[1][0]=(Button)findViewById(R.id.button_10);
        buttons[1][1]=(Button)findViewById(R.id.button_11);
        buttons[1][2]=(Button)findViewById(R.id.button_12);
        buttons[2][0]=(Button)findViewById(R.id.button_30);
        buttons[2][1]=(Button)findViewById(R.id.button_31);
        buttons[2][2]=(Button)findViewById(R.id.button_32);




        for(int i=0;i<3;i++)
         for(j=0;j<3;j++)
             buttons[i][j].setOnClickListener(this);










    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        if(!b.getText().toString().equals(""))
        {

            return;
        }
        if(player1Turn)
        {

            b.setText("X");

        }
        else{

            b.setText("0");
        }
            roundCounts++;

        if(checkForWin())
        if(player1Turn)
        {
            player1Wins();
        }
        else{
            player2Wins();
        }
        else
            if(roundCounts==9)
            {
                draw();
            }

            else{

                player1Turn=!player1Turn;
            }




    }

    private void draw() {

        Toast.makeText(this,"DRAW!!!!!!!",Toast.LENGTH_SHORT).show();
    }

    private void player1Wins() {

        player1points++;
        Toast.makeText(this,"PLAYER1 WINS!!!!!!!!",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }


    private void player2Wins() {

        player1points++;
        Toast.makeText(this,"PLAYER2 WINS!!!!!!!!",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }









    private void updatePointText()
    {
        textViewPlayer1.setText("Player 1:"+player1points);
        textViewPlayer2.setText("Player 2:"+player2points);

    }
    private void resetBoard()
    {

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)

                buttons[i][j].setText("");

        roundCounts=0;
        player1Turn=true;

    }
private void resetGame()
{
    player1points=0;
    player2points=0;
    updatePointText();
    resetBoard();
}


    private boolean checkForWin()
    {
        String[][] field=new String[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                field[i][j]=buttons[i][j].getText().toString();


            for(int i=0;i<3;i++)
            {
                if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals(""))
                {
                    return true;
                }
            }






        for(int i=0;i<3;i++)
        {
            if(field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals(""))
            {
                return true;
            }
        }


        if(field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals(""))
        {
            return true;
        }


        if(field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals(""))
        {
            return true;
        }

        return false;















    }
    }

