package GUIModel;

public class GUIController{

    // Main
    public static void main(String[] args) {
        TitleGUI GUITitle = new TitleGUI();
    }

    /**
     * ChangeLog 0.1:
     * 	Spelling error corrected for VISONPOT, HEALTHPOT.
     *
     * Current List of Entitys that may need Images:
     * These are also the current keywords belonging to room entiies and the priority of getting a image for them
     * HighPriority: WALL(WP/DOWN/LEFT/RIGHT), DOOR(UP/DOWN/LEFT/RIGHT)    					*** These are in eveyroom in some combination
     *  *	|	 |	: <Items, special> OBJECTIVE, START, EXIT && <Monster> GOBLIN				*** These are core gameplay elements
     *  * \|/	\|/	: <Items, normal> VISIONPOT, HEALTHPOT && <Monster> OGER, SKELETON	*** These are secondary elements, work on them after core
     * LowPriority :
     */

    /**
     * Will also need a health and number of potions information display
     * that will receive as input strings containing the Hero's name, and the
     * number each item available
     */

    /**
     * Still need to display doors and walls and background from calling in the room stuff
     */
}
