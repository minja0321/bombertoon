package client;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Matching extends BasicGameState {
	private int state;
	private Image match;
private Music matchBGM;
	private Sound matched;
	// private static TransmissionClient tc; // 一つのクライアントで一つの送信機

	Matching(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO 自動生成されたメソッド・スタブ
		match = new Image("Scene\\matching\\matching.png");
		matchBGM = new Music("BGM\\matchingBGM.ogg");
		matched = new Sound("SE\\matched.ogg");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		match.draw();
		// arg2.drawString("matching now", 100, 100);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		if (ClientStarter.getTransmissionClient() == null) { // tcが作られていなかったら返す

			// TODO debug
			System.out.println("waiting");

			return;
		}

		if (ClientStarter.getTransmissionClient().isReady()) {

			// TODO debug
			System.out.println("matchingからbattleへ");
			matched.play();
			arg1.enterState(State.GAMECLIENT, new FadeOutTransition(Color.black, 1000),
					new FadeInTransition(Color.black, 1000));
		}

	}

	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		ClientStarter.createTransmissionClient();
		matchBGM.loop();
	};

	@Override
	public int getID() {
		return state;
	}

}
