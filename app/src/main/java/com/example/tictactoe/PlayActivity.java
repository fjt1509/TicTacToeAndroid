package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    Button btnReplay;
    String CurrentPlayer;
    TextView txtCurrentPlayer;
    TextView txtWin;
    Button ID00;
    Button ID10;
    Button ID20;
    Button ID01;
    Button ID11;
    Button ID21;
    Button ID02;
    Button ID12;
    Button ID22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        txtCurrentPlayer = this.findViewById(R.id.txtCurrentPlayer);
        txtWin = this.findViewById(R.id.txtWin);
        btnReplay = this.findViewById(R.id.btnReplay);
        btnReplay.setVisibility(View.GONE);


        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });


        ButtonGridSetup();
        GameSetup();
    }

    private void GameSetup() {
        CurrentPlayer = "Player1";
        txtCurrentPlayer.setText("Players Turn: " + CurrentPlayer);
    }


    private void MarkSpot(Button markBtn) {

        String signature;

        if(markBtn.getText().toString().isEmpty())
        {
            if(CurrentPlayer.equals("Player1")) {
                signature = "O";
            }
            else {
                signature = "X";
            }

            markBtn.setText(signature);
            markBtn.setContentDescription(signature);

            if(CheckWin(signature))
            {
                InitWin();
            }
            if(CheckDraw(signature))
            {
                InitDraw();
            }
            else
            {
                ChangeTurn();
            }

        }

    }

    private void InitDraw() {
        txtWin.setText("It's a Draw :(");
        btnReplay.setVisibility(View.VISIBLE);
        txtCurrentPlayer.setVisibility(View.GONE);
        DisableBoard();
    }



    private void InitWin() {
        txtWin.setText(CurrentPlayer + " HAS WON ! :D");
        btnReplay.setVisibility(View.VISIBLE);
        txtCurrentPlayer.setVisibility(View.GONE);
        DisableBoard();


    }

    private void DisableBoard() {
        ID00.setEnabled(false);
        ID10.setEnabled(false);
        ID20.setEnabled(false);
        ID01.setEnabled(false);
        ID11.setEnabled(false);
        ID21.setEnabled(false);
        ID02.setEnabled(false);
        ID12.setEnabled(false);
        ID22.setEnabled(false);
    }



    private boolean CheckDraw(String signature) {
        if(!ID00.getContentDescription().toString().isEmpty() &&
                !ID10.getContentDescription().toString().isEmpty() &&
                !ID20.getContentDescription().toString().isEmpty() &&
                !ID01.getContentDescription().toString().isEmpty() &&
                !ID11.getContentDescription().toString().isEmpty() &&
                !ID21.getContentDescription().toString().isEmpty() &&
                !ID02.getContentDescription().toString().isEmpty() &&
                !ID12.getContentDescription().toString().isEmpty() &&
                !ID22.getContentDescription().toString().isEmpty())
        {
            return true;
        }
        else {
            return false;
        }
    }



    private void ChangeTurn() {
        if (CurrentPlayer.equals("Player1"))
        {
            CurrentPlayer = "Player2";
        }
        else
        {
            CurrentPlayer = "Player1";
        }

        txtCurrentPlayer.setText("Players Turn: " + CurrentPlayer);

    }

    private boolean CheckWin(String signature) {

        if(ID00.getContentDescription().toString().equals(signature) && ID10.getContentDescription().toString().equals(signature) && ID20.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID01.getContentDescription().toString().equals(signature) && ID11.getContentDescription().toString().equals(signature) && ID21.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID02.getContentDescription().toString().equals(signature) && ID12.getContentDescription().toString().equals(signature) && ID22.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID00.getContentDescription().toString().equals(signature) && ID01.getContentDescription().toString().equals(signature) && ID02.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID10.getContentDescription().toString().equals(signature) && ID11.getContentDescription().toString().equals(signature) && ID12.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID20.getContentDescription().toString().equals(signature) && ID21.getContentDescription().toString().equals(signature) && ID22.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID00.getContentDescription().toString().equals(signature) && ID11.getContentDescription().toString().equals(signature) && ID22.getContentDescription().toString().equals(signature)) {
            return true;
        }
        if(ID20.getContentDescription().toString().equals(signature) && ID11.getContentDescription().toString().equals(signature) && ID02.getContentDescription().toString().equals(signature)) {
            return true;
        }

        return false;



    }


    private void ButtonGridSetup() {
        ID00 = this.findViewById(R.id.ID00);
        ID10 = this.findViewById(R.id.ID10);
        ID20 = this.findViewById(R.id.ID20);
        ID01 = this.findViewById(R.id.ID01);
        ID11 = this.findViewById(R.id.ID11);
        ID21 = this.findViewById(R.id.ID21);
        ID02 = this.findViewById(R.id.ID02);
        ID12 = this.findViewById(R.id.ID12);
        ID22 = this.findViewById(R.id.ID22);

        ID00.setContentDescription("");
        ID10.setContentDescription("");
        ID20.setContentDescription("");
        ID01.setContentDescription("");
        ID11.setContentDescription("");
        ID21.setContentDescription("");
        ID02.setContentDescription("");
        ID12.setContentDescription("");
        ID22.setContentDescription("");

        ID00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID00);
            }
        });
        ID10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID10);
            }
        });
        ID20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID20);

            }
        });

        ID01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID01);
            }
        });
        ID11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID11);
            }
        });

        ID21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID21);

            }
        });

        ID02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID02);
            }
        });

        ID12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID12);
            }
        });

        ID22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkSpot(ID22);

            }
        });

    }
}
