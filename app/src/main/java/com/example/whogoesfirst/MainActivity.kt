package com.example.whogoesfirst

import android.os.Bundle  // imports the following
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var teamOne: EditText  // initializes the listed variables and their types
    private lateinit var teamTwo: EditText
    private lateinit var randomTeamButton: Button
    private lateinit var clearTeamsButton: Button
    private lateinit var teamResult: TextView
    private var teamList: MutableList<String> = mutableListOf()  // initializes a mutable string variable teamList


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamOne = findViewById(R.id.team_one_input)  // ties the listed variables to the applicable resource ID
        teamTwo = findViewById(R.id.team_two_input)
        randomTeamButton = findViewById(R.id.select_team_button)
        clearTeamsButton = findViewById(R.id.clear_teams_button)
        teamResult = findViewById(R.id.print_team_result)

        randomTeamButton.setOnClickListener {  // sets OnCLickListener for randomTeamButton
            val team1 = teamOne.text  // stores user input values as team1 variable
            val team2 = teamTwo.text  // stores user input values as team2 variable
            if (team1.isBlank() || team2.isBlank()) {  // if team1 OR team2 EditTexts are blank
                Toast.makeText(this, "Enter both teams to start the match", LENGTH_SHORT).show()  // the following Toast message prints
            } else {
                Toast.makeText(this, "Selecting a random team from $team1 and $team2", LENGTH_SHORT).show()  // the following Toast message prints
                teamList.add(team1.toString())  // adds team1 user input to teamList mutable list and converts to string data type
                teamList.add(team2.toString())  // adds team2 user input to teamList mutable list and converts to string data type
                displayRandomTeam()  // calls displayRandomTeam function
                randomTeamButton.visibility = View.GONE  // removes the users ability to click the randomTeamButton again without first clearing data from teamList mutable List
            }

        clearTeamsButton.setOnClickListener {  // sets onClickListener for clearTeamsButton
            clearTeams()  // calls clearTeams function
            randomTeamButton.visibility = View.VISIBLE  // makes randomTeamButton visible once more
            teamOne.requestFocus()  // moves user input focus to teamOne EditText box
            }
        }
        return
    }

    private fun displayRandomTeam() {  // defines displayRandomTeam function
        val randomTeam = teamList.random()  // initializes randomTeam variable to store random item from teamList
        teamResult.text = getString(R.string.will_play_today, randomTeam)  // prints the listed text in the teamResult TextView

    }

    private fun clearTeams(){  // defines clearTeams function
            teamList.clear()  // clears all previous user input from the mutableList teamList
            teamOne.setText("") // resets teamOne EditText box to empty string
            teamTwo.setText("")  // resets teamTwo EditText box to empty string
            teamResult.text = ""  // resets the teamResult TextView to an empty string 
            return
        }
    }
