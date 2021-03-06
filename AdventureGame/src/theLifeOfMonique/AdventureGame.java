package theLifeOfMonique;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import hsa_new.Console;

/**
 * AdventureGame.java
 * This program follows a high school senior, Monique, at her new high school. The user plays as Monique and experiences different events based on their choices.
 * 27/02/2017
 * @author Victoria Carroll, Angela Chow, Matthew Balkaran 
 */

public class AdventureGame {

	public static void main(String[] args) {
		Console c = new Console(40, 140, "A Day in The Life of Monique"); //sets the console to be larger whilst giving it a title
		int playAgainLoop = 1; //loops the game while it equals 1, only changes if user answers "no" when asked to play again
		BufferedImage pngImage1 = null;
		BufferedImage pngImage2 = null;
		BufferedImage pngImage3 = null;
		BufferedImage pngImage4 = null;
		BufferedImage pngImage5 = null;
		BufferedImage pngImage6 = null;
		BufferedImage pngImage7 = null;
		BufferedImage pngImage8 = null;
		BufferedImage pngImage9 = null;
		BufferedImage pngImage10 = null;
		BufferedImage pngImage11 = null;
		BufferedImage pngImage12 = null;
		BufferedImage pngImage13 = null;
		BufferedImage pngImage14 = null;
		BufferedImage pngImage15 = null;
		BufferedImage pngImage16 = null;
		BufferedImage pngImage17 = null;
		BufferedImage pngImage18 = null;
		BufferedImage pngImage19 = null;
		BufferedImage pngImage20 = null;
		try {
			pngImage1 = ImageIO.read(new File("adventure game pics/characters.png"));
			pngImage2 = ImageIO.read(new File("adventure game pics/bedroom.png"));
			pngImage3 = ImageIO.read(new File("adventure game pics/kitchen.png"));
			pngImage4 = ImageIO.read(new File("adventure game pics/bike.png"));
			pngImage5 = ImageIO.read(new File("adventure game pics/drive.png"));
			pngImage6 = ImageIO.read(new File("adventure game pics/school with mom.png"));
			pngImage7 = ImageIO.read(new File("adventure game pics/pizza hut.png"));
			pngImage8 = ImageIO.read(new File("adventure game pics/homecoming.png"));
			pngImage9 = ImageIO.read(new File("adventure game pics/hallway.png"));
			pngImage10 = ImageIO.read(new File("adventure game pics/obliteration.png"));
			pngImage11 = ImageIO.read(new File("adventure game pics/calculus.png"));
			pngImage12 = ImageIO.read(new File("adventure game pics/library.png"));
			pngImage13 = ImageIO.read(new File("adventure game pics/peru.png"));
			pngImage14 = ImageIO.read(new File("adventure game pics/party.png"));
			pngImage15 = ImageIO.read(new File("adventure game pics/cafe.png"));
			pngImage16 = ImageIO.read(new File("adventure game pics/fight kick.png"));
			pngImage17 = ImageIO.read(new File("adventure game pics/fight pull.png"));
			pngImage18 = ImageIO.read(new File("adventure game pics/police.png"));
			pngImage19 = ImageIO.read(new File("adventure game pics/cat.png"));
			pngImage20 = ImageIO.read(new File("adventure game pics/ditch.png"));	
		} catch (IOException e) {
			System.err.println("There was an error loading the image.");
			e.printStackTrace();
		}
		//The images (1 - 20) are declared and loaded before the loop, doesn't need to re-load after each loop
		Clip boo = null;
		Clip jacob = null; 
		Clip clap = null;
		Clip lose = null;
		Clip bike = null;
		Clip boom = null;
		while (playAgainLoop == 1) {
			try {
				boo = AudioSystem.getClip();
				boo.open(AudioSystem.getAudioInputStream(new File("Audio/Small Crowd Booing Sound Effect.wav")));
				jacob = AudioSystem.getClip();
				jacob.open(AudioSystem.getAudioInputStream(new File("Audio/sweatshirt.wav")));
				clap = AudioSystem.getClip();
				clap.open(AudioSystem.getAudioInputStream(new File("Audio/clapping.wav")));
				lose = AudioSystem.getClip();
				lose.open(AudioSystem.getAudioInputStream(new File("Audio/fail.wav")));
				bike = AudioSystem.getClip();
				bike.open(AudioSystem.getAudioInputStream(new File("Audio/motor.wav")));
				boom = AudioSystem.getClip();
				boom.open(AudioSystem.getAudioInputStream(new File("Audio/explosion.wav")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//The audio clips are declared before the loop but loaded each time it loops to reset each sound if user plays again
			c.println("Your name is Monique, is this okay? (Yes/No)"); //If the user says no, it loops until they say yes
			c.drawImage (pngImage1, 175, 200, 750, 422, null); //sets image parameters to take the center of the console
			String userReply; //userReply is always used to get the user's choices with the exception of choosing to play again
			userReply = c.readString();
			if (userReply.equalsIgnoreCase("No")){
				while (!userReply.equalsIgnoreCase("Yes")){ //once in the loop, they will be stuck in the loop unless they type yes, typing anything else will continue the loop
					c.println("The game is called 'A Day in the Life of Monique'... Is this okay? (Yes/No)");
					userReply = c.readString();
				}
			}
			else if (userReply.equalsIgnoreCase("Yes")) {
				do { //This loops allows the user to repeat their choice if they decide to apologize to their parents after complaining
					c.clear();
					c.drawImage (pngImage2, 0, 0, 1160, 844, null);
					if (userReply.equalsIgnoreCase("Apologize")){ //only appears in loop
						c.println("You're forgiven :)");
					}
					c.println("Today is your first day of grade 12. Do you complain to your parents about making you switch schools or go down for breakfast? \n(Complain/Breakfast)"); ///n is used to fit the text to the specified console size 
					userReply = c.readString();
					if (userReply.equalsIgnoreCase("Breakfast")) {
						c.clear();
						c.drawImage (pngImage3, 0, 0, 1160, 844, null); //all images with these parameters (1160 x 844) are background images to the console
						c.println("Would you like to get a drive or bike to school? (Bike/Drive)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Bike")) {
							c.clear();
							bike.start();
							c.drawImage (pngImage4, 0, 0, 1160, 844, null);
							c.println("Would you like to take the safe way or the dangerous way? (Safe/Dangerous)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Dangerous")) {
								bike.stop(); //all ".stops" stop the music after a decision where audio had played to prevent audio from carrying over
								int RNG1 = (int)(Math.random()*9 + 1); //Random Number Generator for 1 - 10)
								if (RNG1 < 6) { //50/50 chance
									c.clear();
									c.println("It was a dream."); //forces the user to play again unlike other loops/endings where it asks for user input 
								}
								else {
									c.clear();								
									lose.start();
									c.drawImage (pngImage20, 0, 0, 1160, 844, null);
									c.println("You fall in a ditch.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										lose.stop();
										c.clear();
									}
									else { //if the user types anything but yes whenever they are asked if they want to play again, the game will close
										playAgainLoop = 2;
										lose.stop();
										c.close();
									}
								}
							}
							else if (userReply.equalsIgnoreCase("Safe")) {
								c.clear();
								bike.stop();
								c.println("You go to the office to get your locker code.");
								c.println("INTENSE! The student president vote is a tie.");
								c.println("As the new girl you have the last vote.");
								c.println("Do you vote for the nice student president or the mean student president? (Nice/Mean).");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Nice")) {
									c.clear();
									jacob.start();
									c.println("WOW! AMAZING! YOU MEET JACOB SATORIUS!! WOOHOO!");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										jacob.stop();
										c.clear();
									}
									else {
										playAgainLoop = 2;
										jacob.stop();
										c.close();
									}
								}
								else if (userReply.equalsIgnoreCase("Mean")) {
									c.clear();
									clap.start();
									c.println("VAMPIRE ATTACK! oh no! Luckily it was Edward. #togetherforever");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										clap.stop();
										c.clear();
									}
									else {
										playAgainLoop = 2;
										clap.stop();
										c.close();
									}
								}
								else { //else statements accept any user input if they mistype something, ends the game and asks if they want to play again
									c.clear();
									lose.start();
									c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										lose.stop();
										c.clear();
									}
									else {
										playAgainLoop = 2;
										lose.stop();
										c.close();
									}
								}
							}
							else {
								c.clear();
								bike.stop();
								lose.start();
								c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									lose.stop();
									c.clear();
								}
								else {
									playAgainLoop = 2;
									lose.stop();
									c.close();
								}
							}
						}
						else if (userReply.equalsIgnoreCase("Drive")) {
							c.clear();
							c.drawImage (pngImage5, 0, 0, 1160, 422, null);
							c.drawImage (pngImage6, 0, 422, 1160, 422, null); // these parameters are half the height of the previous background so that two images can be stacked
							// (-, 422, -, -) changes the y-axis to move the second image accordingly as planned
							c.println("Your mom embarrasses you. Brittany makes fun of you. What do you do? (Fight/Ignore)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Ignore")) {
								c.clear();
								boo.start();
								c.println("Your high school expreience sucks. Don't be a loser");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									boo.stop();
									c.clear();
								}
								else {
									playAgainLoop = 2;
									boo.stop();
									c.close();
								}
							}
							else if (userReply.equalsIgnoreCase("Fight")) {
								c.clear();
								c.println("Would you like to pull her hair or kick her? (Pull/Kick)");
								userReply = c.readString();

								if (userReply.equalsIgnoreCase("Kick")){
									c.clear();
									boo.start();
									c.drawImage (pngImage16, 0, 0, 1160, 844, null);
									c.println("You lost the fight. #loser :(");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										boo.stop();
										c.clear();
									}
									else {
										playAgainLoop = 2;
										boo.stop();
										c.close();
									}
								}
								else if (userReply.equalsIgnoreCase("Pull")){
									c.clear();
									c.drawImage (pngImage17, 0, 0, 1160, 844, null);
									c.println("You win the fight and become extremely popular!");
									c.println("Ah wow! You are one lucky gal. Troy and Chad both ask you out. Who do you choose? (Troy/Chad/Both/Neither)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Troy")){
										c.clear();
										lose.start();
										c.println("UH OH! Troy was dating Brittany. She later finds you and pushes you down the stairs.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											lose.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Chad")){
										c.clear();
										c.drawImage (pngImage7, 0, 0, 1160, 422, null);	
										c.drawImage (pngImage8, 0, 422, 1160, 422, null);
										clap.start();
										c.println("You go on a Pizza Hut date and later become the homecoming queen!");	
										c.println("Would you like to play again? (Yes/No)");

										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											clap.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											clap.stop();
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Neither")){
										c.clear();
										lose.start();
										c.println("How could you do that??? EPIC FAIL!");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											lose.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Both")){
										c.clear();
										c.println("Both dates went amazingly well! You now have to choose one. You're no player! (Troy/Chad)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Troy")){
											c.clear();
											lose.start();
											c.drawImage (pngImage19, 0, 0, 1160, 844, null);
											c.println("You go over to his house to hang out. His cat comes near you and you run because you're allergic and you get hit by a car!");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												lose.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												lose.stop();
												c.close();
											}
										}
										else if (userReply.equalsIgnoreCase("Chad")){ 
											c.clear();
											// user is unable to say no in this segment proceeding forward, if they say no they are looped back to beginning of this segment involving Chad
											do {
												if (userReply.equalsIgnoreCase("No")){
													c.println("What's wrong with you!?");
												}
												c.println("He texts you: 'Do you want to hang out again?'(Yes/No)"); 
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")){
													c.clear();
													if (userReply.equalsIgnoreCase("No")){
														c.println("What's wrong with you!?");
													}
													c.println("Chad proposes! Do you say yes? (Yes/No)");
													userReply = c.readString();
													if (userReply.equalsIgnoreCase("Yes")){
														c.clear();
														clap.start();
														c.println("You live happily ever after!");
														c.println("Would you like to play again? (Yes/No)");
														userReply = c.readString();
														if (userReply.equalsIgnoreCase("Yes")) {
															clap.stop();
															c.clear();
														}
														else {
															playAgainLoop = 2;
															clap.stop();
															c.close();
														}
													}
													else if (userReply.equalsIgnoreCase("No")){
														c.clear();
													}
													else {
														c.clear();
														lose.start();
														c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
														c.println("Would you like to play again? (Yes/No)");
														userReply = c.readString();
														if (userReply.equalsIgnoreCase("Yes")) {
															lose.stop();
															c.clear();
														}
														else {
															playAgainLoop = 2;
															lose.stop();
															c.close();
														}
													}
												}
												else if (userReply.equalsIgnoreCase("No")){
													c.clear();
												}
												else {
													c.clear();
													lose.start();
													c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
													c.println("Would you like to play again? (Yes/No)");
													userReply = c.readString();
													if (userReply.equalsIgnoreCase("Yes")) {
														lose.stop();
														c.clear();
													}
													else {
														playAgainLoop = 2;
														lose.stop();
														c.close();
													}
												}
											} while (userReply.equalsIgnoreCase("No"));
										}
										else {
											c.clear();
											lose.start();
											c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												lose.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												lose.stop();
												c.close();
											}
										}
									}
									else {
										c.clear();
										lose.start();
										c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											lose.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
								}
								else {
									c.clear();
									lose.start();
									c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										lose.stop();
										c.clear();
									}
									else {
										playAgainLoop = 2;
										lose.stop();
										c.close();
									}
								}
							}
							else {
								c.clear();
								lose.start();
								c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									lose.stop();
									c.clear();
								}
								else {
									playAgainLoop = 2;
									lose.stop();
									c.close();
								}
							}
						}
						else {
							c.clear();
							lose.start();
							c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
							c.println("Would you like to play again? (Yes/No)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Yes")) {
								lose.stop();
								c.clear();
							}
							else {
								playAgainLoop = 2;
								lose.stop();
								c.close();
							}
						}
					}
					else if (userReply.equalsIgnoreCase("Complain")) {
						c.clear();
						c.drawImage (pngImage3, 0, 0, 1160, 844, null);
						c.println("You are NOT getting a drive!! - Mom. Would you like to continue complaining or apologize? (Complain/Apologize)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Complain")){
							c.clear();
							c.drawImage (pngImage9, 0, 0, 1160, 844, null);
							c.print("You are late to school but it's okay. You go to the office to get your locker combo. It will be: ");
							int[]lockerCode = new int[4]; //creates array for four ints to be stored
							for (int i = 0; i < lockerCode.length; i++) { //for loop loops the length of the array (4) 
								lockerCode[i] = (int)(Math.random()*9); //for each loop a random number from 0 - 9 is entered into the array corresponding with the increasing for loop counter 
								c.print(lockerCode[i]); //the end goal of the loop is to print these 4 individual randomly generated numbers
							}
							c.println("");
							c.println("Brittany approaches you seeing that you are lost. What is your next class? (Phys.Ed/Calculus)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Phys.Ed")){
								c.clear();
								boom.start();
								c.drawImage (pngImage10, 0, 0, 1160, 844, null);
								c.println("You meet a boy named Troy. You fall madly in love!");									
								c.println("OBLITERATION!");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									boom.stop();
									c.clear();
								}
								else {
									playAgainLoop = 2;
									boom.stop();
									c.close();
								}
							}
							else if (userReply.equalsIgnoreCase("Calculus")){
								c.clear();
								c.drawImage (pngImage11, 0, 0, 1160, 844, null);
								c.println("Awh this class is boring but you meet a cute boy named Chad!");
								c.println("Chad offers to help you with homework. Do you say yes??? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")){
									c.clear();
									c.println("Would you like to study at home, the library, or the caf�? (Home/Library/Cafe)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Library")){
										c.clear();
										clap.start();
										c.drawImage (pngImage12, 0, 0, 1160, 422, null);
										c.drawImage (pngImage13, 0, 422, 1160, 422, null);
										c.println("You and Chad become close friends and together learn Latin and move to Peru!");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											clap.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											clap.stop();
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Cafe")){
										c.clear();
										lose.start();
										c.drawImage (pngImage15, 0, 0, 1160, 844, null);
										c.println("Your ex boyfriend is there and he thinks Chad is your boyfriend. They fight and Chad goes to the hospital.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											lose.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Home")){
										int RNG2 = (int)(Math.random()*9 + 1);
										if (RNG2 < 6) {
											c.clear();
											lose.start();
											c.println("Your mom comes home and catches you and you're grounded for a year.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												lose.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												lose.stop();
												c.close();
											}
										}
										else {
											c.clear();
											clap.start();
											c.println("Chad asks if you want to go to homecoming and you ace your calculus test.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												clap.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												clap.stop();
												c.close();
											}
										}
									}
									else {
										c.clear();
										lose.start();
										c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											lose.stop();
											c.clear();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
								}
								else if (userReply.equalsIgnoreCase("No")){
									c.clear();
									c.println("You decide to call Brittany. Her number is in your locker. What is your locker combination (INPUT EACH NUMBER INDIVIDUALLY)");
									int lockerReply0;
									int lockerReply1;
									int lockerReply2;
									int lockerReply3;
									lockerReply0 = c.readInt();
									lockerReply1 = c.readInt();
									lockerReply2 = c.readInt();
									lockerReply3 = c.readInt();
									if (lockerReply0 == lockerCode[0] && lockerReply1 == lockerCode[1] && lockerReply2 == lockerCode[2] && lockerReply3 == lockerCode[3]){
										c.clear(); //the user must recall what the randomly generated locker number was and enter each number individually into each part of the array
										// if the user gets each number of the code right, they are invited to a party and can further progress
										c.println("She invites you to a party tonight. Do you go? (Yes/No)");
										userReply = c.readString();
										if(userReply.equalsIgnoreCase("No")){
											c.clear();
											lose.start();
											c.println("Wrong choice! Always Party!");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												lose.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												lose.stop();
												c.close();
											}
										}
										else if (userReply.equalsIgnoreCase("Yes")){
											c.clear();
											c.drawImage (pngImage14, 0, 0, 1160, 844, null);
											c.println("The party is amazing!! Troy offers you a drink. Do you take it? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("No")){
												c.clear();
												clap.start();
												c.println("You survive! Congratulations, high school is great!");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													clap.stop();
													c.clear();
												}
												else {
													playAgainLoop = 2;
													clap.stop();
													c.close();
												}
											}
											else if (userReply.equalsIgnoreCase("Yes")){
												c.clear();
												lose.start();
												c.drawImage (pngImage18, 0, 0, 1160, 844, null);
												c.println("You are caught! The police come and you are charged with embezzelment.");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													lose.stop();
													c.clear();
												}
												else {
													playAgainLoop = 2;
													lose.stop();
													c.close();
												}
											}
											else {
												c.clear();
												lose.start();
												c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													lose.stop();
													c.clear();
												}
												else {
													playAgainLoop = 2;
													lose.stop();
													c.close();
												}
											}
										}
										else {
											c.clear();
											lose.start();
											c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												lose.stop();
												c.clear();
											}
											else {
												playAgainLoop = 2;
												lose.stop();
												c.close();
											}
										}
									}
									else { //if the user gets the code wrong, they are brought to a bad end and are asked to play again
										c.clear();
										lose.start();
										c.println("You spend your night at home studying... high school sucks and you're a failure");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
											lose.stop();
										}
										else {
											playAgainLoop = 2;
											lose.stop();
											c.close();
										}
									}
								}
								else {
									c.clear();
									lose.start();
									c.println("You spend your night at home studying... high school sucks and you're a failure");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
										lose.stop();
									}
									else {
										playAgainLoop = 2;
										lose.stop();
										c.close();
									}
								}
							}
							else {
								c.clear();
								lose.start();
								c.println("You spend your night at home studying... high school sucks and you're a failure");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
									lose.stop();
								}
								else {
									playAgainLoop = 2;
									lose.stop();
									c.close();
								}
							}
						}
						else if (userReply.equalsIgnoreCase("Apologize")){
							// This else if is here so that if they decided to apologize, it does not load the else ending for when they incorrectly spell their choice.
						}
						else {
							c.clear();
							lose.start();
							c.println("You spend your night at home studying... high school sucks and you're a failure");
							c.println("Would you like to play again? (Yes/No)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Yes")) {
								c.clear();
								lose.stop();
							}
							else {
								playAgainLoop = 2;
								lose.stop();
								c.close();
							}
						}
					}
					else {
						c.clear();
						lose.start();
						c.println("You spend your night at home studying... high school sucks and you're a failure");
						c.println("Would you like to play again? (Yes/No)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Yes")) {
							c.clear();
							lose.stop();
						}
						else {
							playAgainLoop = 2;
							lose.stop();
							c.close();
						}
					}
				} while (userReply.equalsIgnoreCase("Apologize")); // This is the end of what is contained in the loop. It goes back to do if they decided to apologize.
			}
			else {
				c.clear();
				lose.start();
				c.println("You spend your night at home studying... high school sucks and you're a failure");
				c.println("Would you like to play again? (Yes/No)");
				userReply = c.readString();
				if (userReply.equalsIgnoreCase("Yes")) {
					c.clear();
					lose.stop();
				}
				else {
					playAgainLoop = 2;
					lose.stop();
					c.close();
				}
			}
		}
	}
}