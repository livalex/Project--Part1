# Project--Part1

				    ____ 
				  .'* *.'
			       __/_*_*(_
			      / _______ \
			     _\_)/___\(_/_ 
			    / _((\- -/))_ \
			    \ \())(-)(()/ /
			     ' \(((()))/ '
			    / ' \)).))/ ' \
			   / _ \ - | - /_  \
			  (   ( .;''';. .'  )
			  _\"__ /    )\ __"/_
			    \/  \   ' /  \/
			     .'  '...' ' )
			      / /  |  \ \
			     / .   .   . \
			    /   .     .   \
			   /   /   |   \   \
			 .'   /    b    '.  '.
		     _.-'    /     Bb     '-. '-._ 
		 _.-'       |      BBb       '-.  '-. 
		(________mrf\____.dBBBb.________)____)

			PROJECT-FIRST STAGE

					Name: Livadaru Alexandru-Valentin
					Group: 323CA

			CONSTANS PACKAGE

		CONSTANTS

- All the constants used in the program.

			MAIN
	
		INPUT, INPUTLOADER

- Both help me to read from the file and write in the file.
- For the read and write operations I inspired from the skeleton of the
	previous homework and also from the tutorial given in the
	homework text.

		MAPBUILDER

- Made this class singleton because we use it only once.
- Used to take the input data and create the "map" of the game.

		VECTORCREATOR

- Takes the player type and it's coordinates from the input and creates
	a player of a certain strategy that is added in the 'players' vector.

		ACTIONCREATOR

	CREATEMOVES

- In each round, it takes all the players to the input specified loation
	unless the player does not have the immobility or paralysed effect.

- Check every player's overtime ability (see OVERTIMEABILITY below)


	GROUNDSETTER

- Sets the play ground of every player

	XPGIVER

- Sets the player's current xp using the homework formula then calculates
	the level of the player based on it's hp and updates the hp level.

	BATTLE

- Checks if there are two players in the same position.
- If there are, check for them not to be dead.
- If they are not, always make sure that the wizard atacks second so he can
	use it's deflect ability.
- After the battle, update their stats.

			PLAYERS

		PLAYERSFACTORY

	GETPLAYER

- Takes the input and based on the input, it creates a player.

	
		HUMAN

	CHECKOVERTIMEABILITY

- Checks if the afection is a newly taken one.
- If the player is paralysed and the hit took place in the woods, set the
	overtime ability counter to 6, if not, set it to 3.
- Takes a certain hp and updates the fields.
- If the player is ignited, set the overtime ability counter to 2 and
	update the fields.

- Then it makes the same thing as above, but if their overtime ability is over,
	turn off their paralysed/ignite flags.
- Turn off the new overtime affection and immobility flags.

	WIZARDGAME

- Calculates the hp taken from the victim's life using
	the drain ability.
- For this to happen, we calculate the percentage factor from the formula
	by looking at the level of the atacker, the ground where the action
	took place and the player modificator.
- Checks if there are two wizards fighting because two wizards can't atack
	eachother using deflect.
- If there are not, calculate the damage taken by the ability using the
	homework formula.
- Update the victim's stats.

	PYROGAME

- It calculates the damage of the pyromancer's ability taking into
	consideration the level, the ground and the modifiers.
- Turn on the ignite flag and set the damage taken per round.
- Update the stats of the victim.

	KNIGHTGAME

- It calculates the damage of the knight's ability taking into
	consideration the level, the ground and the modifiers.
- Checks if the victim immediately dies.
- Turn on the immobility flag.
- Update the stats of the victim.

	ROGUEGAME

- It calculates the damage of the rogue's ability taking into
	consideration the level, the ground and the modifiers.
- Checks if the backstab ability is critical or not.
- Turn on the paralysis flag and caluclate the damage taken per round.
- Update the stats of the victim.

	KNIGHT, ROGUE, WIZARD, PYROMANCER

- Created the player with the specific stats of every type of player.

- The DOUBLE DISPATCH concept is used here.

- The player is the 'visitable' BUT also the 'visitator' .

- The methods of the players have all the same name but the program knows
	which method to call using the argument (visitator) and the class
	in which is called (visitable).

	NOTE: 
- Thanks for reading my README. 
- I hope everthing is clear and I wish you a good day!
