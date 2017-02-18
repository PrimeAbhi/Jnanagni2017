package project.jnanagni.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.jnanagni.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final List<DummyItem> Event_Items = new ArrayList<>();
    public static int[] event_about = {R.drawable.tevent, R.drawable.ntevent, R.drawable.sevent, R.drawable.fevent, R.drawable.cevent, R.drawable.workshop};
    public static int[] teventimg = {R.drawable.hydroriser, R.drawable.cipher, R.drawable.electroguisial, R.drawable.annihilator, R.drawable.apptitude, R.drawable.exgesis, R.drawable.concatination, R.drawable.electricio, R.drawable.tinkerer, R.drawable.nopc, R.drawable.inclino, R.drawable.cuandigo, R.drawable.ameliorator, R.drawable.colonizer};
    public static int[] nteventimg = {R.drawable.abhivakti, R.drawable.thirdvision, R.drawable.mist, R.drawable.qcognito, R.drawable.freedoscrawl, R.drawable.brushndpaint, R.drawable.creativefashionshw, R.drawable.enthuse};
    public static int[] geventimg = {R.drawable.carrom, R.drawable.tabletennis, R.drawable.badminton, R.drawable.needforspeed, R.drawable.counterstrike, R.drawable.fifa};
    public static int[] feventimg = {R.drawable.rubik, R.drawable.minimilitia, R.drawable.bowling, R.drawable.dart, R.drawable.throwball};
    public static int[] ceventimg = {R.drawable.anukriti, R.drawable.sargam, R.drawable.rocksynrom, R.drawable.kritika, R.drawable.lol};
    public static int[] meventsimg = {R.drawable.samagam, R.drawable.symvogue};


    public static String[] event_name = {"Technical", "Non-Technical", "Game On", "Fun", "Cultural", "Mega"};
    public static String[] tevents = {"HydroRiser", "Ci-Pher", "ElectoGuisial", "Annihilator", "Aptitude", "Exgesis", "ConCatenation", "Electricio", "Tinkerer", "Nopc", "Inclicno", "Cuandigo", "Ameliorator", "Colonizer"};
    public static String[] ntevents = {"Abhivakti", "Third Vision", "Mist Treasure Hunt", "Q-Cognito", "FreedoScrawl", "Brush N Paint", "Creative Fasion Show", "Enthuse",};
    public static String[] gevents = {"Carrom", "Table Tennis", "Chess", "Badminton", "NFS", "Counter Strike", "Fifa"};
    public static String[] fevents = {"Rubik's Cube", "Mini-Militia", "Bowling", "Dart", "ThrowBall"};
    public static String[] cevents = {"Anukriti", "Sargam", "Rock Syndrome", "Kritika", "Lol"};
    public static String[] mevents = {"Samagam", "Symvogue", "Celebrity Visit", "StartUp Fair"};

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 6;
    private static final int COUNTS = 14;

    static {
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }
    static {
        for (int j=0; j<COUNTS;j++){
            addItemForEvent(createEventItem(j));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static void addItemForEvent(DummyItem item) {
        Event_Items.add(item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(event_about[position], event_name[position]);
    }

    private static DummyItem createEventItem(int position) {
        return new DummyItem(teventimg[position], tevents[position]);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final int id;
        public final String content;

        public DummyItem(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
