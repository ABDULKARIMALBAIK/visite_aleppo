package com.alepposyria.visitealeppo.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alepposyria.visitealeppo.Adapter.RecyclerAdapter;
import com.alepposyria.visitealeppo.Objects.ObjectHistory;
import com.alepposyria.visitealeppo.Objects.ObjectLocation;
import com.alepposyria.visitealeppo.R;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class historyFragment extends Fragment {

    //instance is variable to give us fragment (historyFragment)
    //recyclerView is variable we can say is adapter to historyFragment's items

    public  static RecyclerView recyclerView;
    private ArrayList<ObjectHistory> history = new ArrayList<ObjectHistory>();

    //this is List of elements to historyFragment
    private  static  historyFragment instance = null;

    public historyFragment() {
       CreateListObjectsHistory(getActivity());
    }

    private  void CreateListObjectsHistory(Activity activity){

        //if list (history) is empty (the fragment is appeared one time) add items to fragment
        //this condition for fragment if appeared one time ; it run , but in next time  we do not add items again ;because we added in last time , so not run
        //NOTE : i do not use this statement (getString(R.string.'''');) because i will have runTime error !!!!!!!!!

        if (history.isEmpty() ){
            history.add(new ObjectHistory(R.drawable.picture_pre_history_and_pre_classical_era ,"Pre-history and pre-classical era" ," Aleppo has scarcely been touched by archaeologists,\n" +
                    "since the modern city occupies its ancient site.\n" +
                    "The site has been occupied from around 5000 BC, as shown by excavations in Tallet Alsauda.\n" +
                    " Aleppo appears in historical records as an important city much earlier than Damascus.\n" +
                    "The first record of Aleppo comes from the third millennium BC, in the Ebla tablets when Aleppo was referred to as Ha-lam.\n" +
                    "Some historians, such as Wayne Horowitz, identify Aleppo with the capital of an independent kingdom closely related to Ebla, known as Armi, although this identification is contested.\n" +
                    "The main temple of the storm god Hadad was located on the citadel hill in the center of the city, when the city was known as the city of Hadad."));

            history.add(new ObjectHistory(R.drawable.picture_classical_antiquity , "Classical antiquity" , "Alexander the Great took over the city in 333 BC. \n" +
                    "Seleucus Nicator established a Hellenic settlement in the site between 301 and 286 BC. \n" +
                    "He called it Beroea , after Beroea in Macedon.\n" +
                    "Northern Syria was the center of gravity of the Hellenistic colonizing activity, and therefore of Hellenistic culture in the Seleucid Empire. \n" +
                    "As did other Hellenized cities of the Seleucid kingdom, Beroea probably enjoyed a measure of local autonomy, with a local civic assembly or boulē composed of free Hellenes"));


            history.add(new ObjectHistory(R.drawable.picture_ecclesiastical_history2, "Ecclesiastical history" , "The names of several bishops of the episcopal see of Beroea, which was in the Roman province of Syria Prima, are recorded in extant documents. \n" +
                    "The first whose name survives is that of Saint Eustathius of Antioch, who, after being bishop of Beroea, was transferred to the important metropolitan see of Antioch shortly before the 325 First Council of Nicaea. \n" +
                    "His successor in Beroea Cyrus was for his fidelity to the Nicene faith sent into exile by the Roman Emperor Constantius II.\n" +
                    "After the Council of Seleucia of 359, called by Constantius, Meletius of Antioch was transferred from Sebastea to Beroea but in the following year was promoted to Antioch. \n" +
                    "His successor in Beroea, Anatolius, was at a council in Antioch in 363. Under the persecuting Emperor Valens, the bishop of Beroea was Theodotus, a friend of Basil the Great.\n" +
                    "He was succeeded by Acacius of Beroea, who governed the see for over 50 years and was at the First Council of Constantinople in 381 and the Council of Ephesus in 431. \n" +
                    "In 438, he was succeeded by Theoctistus, who participated in the Council of Chalcedon in 451 and was a signatory of the joint letter that the bishops of the province of Syria Prima sent in 458 to Emperor Leo I the Thracian about the murder of Proterius of Alexandria. \n" +
                    "In 518 Emperor Justin I exiled the bishop of Beroea Antoninus for rejecting the Council of Chalcedon."));

            history.add(new ObjectHistory(R.drawable.picture_medieval_period, "Medieval period", "The Sassanid Persians invaded and controlled Syria briefly in the early 7th century.\n" +
                    "Soon after Aleppo fell to Muslims under Abu Ubaidah ibn al Jarrah in 637.\n" +
                    "In 944, it became the seat of an independent Emirate under the Hamdanid prince Sayf al-Daula, and enjoyed a period of great prosperity, being home to the great poet al-Mutanabbi and the philosopher and polymath al-Farabi.\n" +
                    "The city was sacked by a resurgent Byzantine Empire in 962, while Byzantine forces occupied it briefly from 974 to 987.\n" +
                    "The city and its Emirate became an Imperial vassal from 969 until the Byzantine–Seljuk Wars.\n" +
                    "The city was besieged by the Crusaders in 1124, but was not conquered.\n" +
                    "On 9 August 1138, a deadly earthquake ravaged the city and the surrounding area.\n" +
                    "Although estimates from this time are very unreliable, it is believed that 230,000 people died, making it the sixth deadliest earthquake in recorded history.\n" +
                    "In 1128 Aleppo became capital of the expanding Zengid dynasty, which ultimately conquered Damascus in 1154.\n" +
                    "In 1183 Aleppo came under the control of Saladin and then the Ayyubid Dynasty.\n" +
                    "When the Ayyubids were toppled in Egypt by the Mamluks, the Ayyubid emir of Aleppo An-Nasir Yusuf became sultan of the remaining part of the Ayyubid Empire.\n" +
                    "He ruled Syria from his seat in Aleppo until, on 24 January 1260,[45] the city was taken by the Mongols under Hulagu in alliance with their vassals the Frank knights of the ruler of Antioch Bohemond VI and his father-in-law the Armenian ruler Hetoum I."));

            history.add(new ObjectHistory(R.drawable.picture_ottoman_era, "Ottoman era" , "\"Aleppo became part of the Ottoman Empire in 1516, when the city had around 50,000 inhabitants or 11,224 households according to an Ottoman census.\n" +
                    "It was the centre of the Aleppo Eyalet; the rest of what later became Syria was part of either the eyalets of Damascus, Tripoli, Sidon or Raqqa.\n" +
                    "Following the Ottoman provincial reform of 1864 Aleppo became the centre of the newly constituted Vilayet of Aleppo in 1866.\n" +
                    "Thanks to its strategic geographic location on the trade route between Anatolia and the east, Aleppo rose to high prominence in the Ottoman era, at one point being second only to Constantinople in the empire.\n" +
                    "By the middle of the 16th century, Aleppo had displaced Damascus as the principal market for goods coming to the Mediterranean region from the east.\n" +
                    "This is reflected by the fact that the Levant Company of London, a joint-trading company founded in 1581 to monopolize England's trade with the Ottoman Empire, never attempted to settle a factor, or agent, in Damascus, despite having had permission to do so.\n" +
                    "Aleppo served as the company's headquarters until the late 18th century.\""));

            history.add(new ObjectHistory(R.drawable.picture_french_mandate, "French mandate" , "The State of Aleppo was declared by the French General Henri Gouraud in September 1920 as part of a French scheme to make Syria easier to control by dividing it into several smaller states.\n" +
                    "France became more hostile to the idea of a united Syria after the Battle of Maysaloun.\n" +
                    "By separating Aleppo from Damascus, Gouraud wanted to capitalize on a traditional state of competition between the two cities and turn it into political division.\n" +
                    "The people in Aleppo were unhappy with the fact that Damascus was chosen as capital for the new nation of Syria.\n" +
                    "Gouraud sensed this sentiment and tried to manipulate it by making Aleppo the capital of a large and wealthier state with which it would have been hard for Damascus to compete.\n" +
                    "The State of Aleppo as drawn by France contained most of the fertile area of Syria: the fertile countryside of Aleppo in addition to the entire fertile basin of river Euphrates.\n" +
                    "The state also had access to sea via the autonomous Sanjak of Alexandretta.\n" +
                    "On the other hand, Damascus, which is basically an oasis on the fringes of the Syrian Desert, had neither enough fertile land nor access to sea.\n" +
                    "Basically, Gouraud wanted to lure Aleppo by giving it control over most of the agricultural and mineral wealth of Syria so that it would never want to unite with Damascus again."));

            history.add(new ObjectHistory(R.drawable.picture_post_independence , "Post-independence" , "The period immediately following independence from France was marked by increasing rivalry between Aleppo and Damascus.\n" +
                    "Aleppo feverishly called for an immediate union between Syria and Hashimite Iraq, a demand that was firmly rejected by Damascus.\n" +
                    "Instead, Damascus favoured a pro-Egyptian, pro-Saudi orientation and actively participated in the establishment of the Arab League in Alexandria in 1944, an organization that was seen by many Arab nationalists as a \\'conspiracy\\' aimed against the unification of the Fertile Crescent under the Hashimites.\n" +
                    "The increasing disagreements between Aleppo and Damascus led eventually to the split of the National Block into two factions: the National Party, established in Damascus in 1946, and the People\\'s Party, established in Aleppo in 1948 by Rushdi Kikhya and Nazim Qudsi.\n" +
                    "An underlying cause of the disagreement, in addition to the union with Iraq, was Aleppo\\'s intention to relocate the capital from Damascus.\n" +
                    "The issue of the capital became an open debate matter in 1950 when the Popular Party presented a constitution draft that called Damascus a \\\"temporary capital\\\"."));



        }
    }

    public  static  historyFragment getInstance(){

        //First time the fragment is appeared
        if (instance == null)
            return  new historyFragment();

         //not First time the fragment is appeared
        else
            return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_history, container, false);

        //combine variable (recyclerView) with views in XML file , and set values in recyclerView's attributes
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview6);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //the adapter take list (Location) and value is type for we know this fragment is location or history
        RecyclerAdapter adapter = new RecyclerAdapter(0 , history);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


}
