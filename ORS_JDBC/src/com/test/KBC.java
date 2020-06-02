package com.test;

import java.util.Scanner;

public class KBC {
	String questions[];
	String options[][];
	int answers[];
	long money[];
	int history[];
	boolean lifelines[];
	static int games = 0;

	public int getRandomQuestion() {
		int i = (int) (Math.random() * questions.length);
		return i;
	}

	public KBC() {
		questions = new String[] { "Which of the following corresponds to ‘ek bataa do’?",
				"Which of the following gods is also known as ‘Gauri Nandan’?",
				"Where was the BRICS summit held in 2014?",
				"Who wrote the introduction to the English translation of Rabindranath Tagore’s Gitanjali?",
				"Which is the second most spoken language of Nepal?",
				"In which of these two sports is the term ‘free hit’ used?",
				" Which country will host the 45th G7 summit 2019?",
				" Which country’s women cricket team has clinched the Asia Cup Twenty-20 tournament 2018?",
				"The Maratha and The Kesri were the two main newspapers started by which of the following people?",
				"The Chauri Chaura incident took place in 1922 and finds prominence in India’s national movement. Can you identify the state in which Chauri Chaura is located?",
				" Who is the first non-Indian to receive the Bharat Ratna?",
				"What is the new name of Feroz Shah Kotla ground?",
				"Which of the following statement is not correct about ICC World Cup 2019?",
				" Who got FIFA Best Player 2019 Award?" };
		options = new String[][] { { "1. Pura", "2. Sawa", "3. Adha", "4. Pauna" },
				{ "1. Agni", "2. Indra", "3. Hanuman", "4. Ganesh" },
				{ "1. Brazil", "2. India", "3. Russia", "4. China" },
				{ "1. P.B. Shelley", "2. Alfred Tennyson", "3. W.B. Yeats", "4.  T.S. Elliot" },
				{ "1. Bajjika", "2. Nepali", "3. Maithili", "4. Bojepuri" },
				{ "1. Football, Squash", "2. Badminton, Tennis", "3. Badminton, Cricket", "4. Hockey, Cricket" },
				{ "1. Italy", "2. Germany", "3. France", "4. Canada" },
				{ "1. South Korea", "2. India", "3. Bangladesh", "4. Pakistan" },
				{ "1. Bal Gangadhar Tilak", "2. Gopal Krishna Gokhale", "3. Lala Lajpat Rai",
						"4. Madan Mohan Malviya" },
				{ "1. Maharashtra", "2. Madhya Pradesh", "3. Gujarat", "4. Uttar Pradesh" },
				{ "1. Martin Luther King", "2. Khan Abdul Ghaffar Khan", "3. Mother Teresa", "4. Aubin Mehta" },
				{ "1. Arun Jaitley Stadium", "2. Sheila Dikshit Stadium", "Gautam Gambhir Stadium",
						"4. Ajit Wadekar Stadium" },
				{ "1. It was the 12th edition of the ICC cricket World Cup",
						"2. Rohit Sharma has scored 6 centuries in this tournament",
						"3. Australia Mitchell Starc was the leading wicket taker in the tournament",
						"4. Mohammad Shami and Trent Boult took the hat trick in this tournamen" },
				{ "1.  Neymar", "2. L. Messi", "3.  C. Ronaldo", "4. Luka Mordic" } };
		answers = new int[] { 3, 4, 1, 3, 3, 4, 3, 3, 1, 4, 2, 1, 2, 2 };
		money = new long[] { 1000, 2000, 4000, 10000, 20000, 40000, 80000, 160000, 320000, 625000, 1250000, 2500000,
				5000000, 10000000 };
		history = new int[15];
		lifelines = new boolean[] { false, false, false };

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		if (games == 10)
			System.out.println("get a life");
		if (games == 0)
			System.out.println("\fWelcome to KBC\n\n");
		System.out.println("Your First Question is :\n");
		KBC k = new KBC();
		int n = 0;
		for (int i = 0; i < k.questions.length; i++) {
			int r;
			do {
				r = k.getRandomQuestion();
			} while (k.history[r] == 1);
			System.out.println(k.questions[r]);
			System.out.println(k.options[r][0]);
			System.out.println(k.options[r][1]);
			System.out.println(k.options[r][2]);
			System.out.println(k.options[r][3]);

			System.out.println("Press 1,2,3 or 4\nIf you do not know the answer enter 0 to use a lifeline");
			choice = sc.nextInt();
			while (choice > 4) {
				System.out.println("Please enter only 1,2,3 or 4");
				choice = sc.nextInt();
			}
			if (choice == 0) {
				boolean boo = true;
				if (k.lifelines[0] == true && k.lifelines[1] == true && k.lifelines[2] == true
						&& k.lifelines[3] == true)
					boo = false;
				if (boo) {
					System.out.println(
							"Enter 1 to use 50/50\n Enter 2 ask RajniKanth\n Enter 3 to change the question\n Enter 4 to use audience pool");
					int c = sc.nextInt() - 1;
					while (k.lifelines[c] == true) {
						System.out.println(
								"Sorry you have used this lifelines. Please another by entering the respective number.");
						c = sc.nextInt() - 1;
					}
					k.lifelines[c] = true;
					switch (c) {
					case 0:
						int rand;
						do {
							rand = (int) (Math.random() * 4);
						} while (rand == k.answers[i] - 1);
						if (rand < (k.answers[r] - 1))
							System.out.println("The remaining options are\n" + k.options[r][rand] + "\n"
									+ k.options[r][k.answers[r] - 1]);
						else {
							System.out.println("The remaining options are\n" + k.options[r][k.answers[r] - 1] + "\n"
									+ k.options[r][rand]);
							break;
						}
					case 1:
						System.out.println("Rajnikanth says the answer is " + k.answers[r]);
						break;
					case 2:
						k.history[r] = 1;
						System.out.println("\fYour new Question is : \n");
						continue;
					case 3:
						
					}

				} else
					System.out.println("Sorry you have used all your lifelines.");
				System.out.println("What is your Final answer?");
				choice = sc.nextInt();
			}
			n++;
			if (choice == k.answers[r]) {
				if (n == 15)
					System.out.println("\nCorrect answer\nCONGRATULATIONS!!!YOU ARE A CROREPATI!\n You Won RS."
							+ k.money[i] + "\n\n Thanks For Playing : ");
				else
					System.out.println("\nCorrect answer \nYou Won Rs." + k.money[i] + "\n");
			} else {
				System.out.println("\nYou Lose\n\nGame Over !!");
				if (i >= 1)
					System.out.println("Your Total Prize Money :Rs." + k.money[i - 1]);
				else
					System.out.println("Your Total Prize Money :Rs.");
				break;
			}
			k.history[r] = 1;
			System.out.println("Enter any letter to Continue");
			String v = sc.next();
			System.out.println("\f");
		}
		System.out.println("Do You Want to Play Again?(y/n)");
		char c = sc.next().charAt(0);
		if (c == 'y' || c == 'n') {
			games++;
			main(null);
		} else
			System.out.println("Thanks For Playing!");
	}

}
