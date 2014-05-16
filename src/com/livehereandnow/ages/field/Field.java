package com.livehereandnow.ages.field;

//import com.livehereandnow.ages.components.CardArray;
import com.livehereandnow.ages.card.AgesCard;
import com.livehereandnow.ages.card.AgesCardFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import com.livehereandnow.ages.components.Points;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mark
 */
public class Field {

    AgesCardFactory cardFactory;
    private List<AgesCard> allCards;
    private List<AgesCard> qryCards;
    private List<AgesCard> 卡牌列;
    private List<AgesCard> 時代A內政牌;
    private List<AgesCard> 時代I內政牌;
    private List<AgesCard> 時代II內政牌;
    private List<AgesCard> 時代III內政牌;
    private List<AgesCard> 時代A軍事牌;
    private List<AgesCard> 時代I軍事牌;
    private List<AgesCard> 時代II軍事牌;
    private List<AgesCard> 時代III軍事牌;
    private List<AgesCard> 未來事件;
    private List<AgesCard> 當前事件;

    private FieldPlayer p1;
    private FieldPlayer p2;
    private FieldPlayer currentPlayer;
    private List<FieldPlayer> allPlayers;

    private Points round;

    public void 交換玩家() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
            return;
        }
        if (currentPlayer == p2) {
            currentPlayer = p1;
//            System.out.println("auto to next 回合");
            round.addPoints(1);
            return;
        }

    }

    public AgesCard getNOCARD() {
        return cardFactory.getNOCARD();
    }

    public List<AgesCard> getAllCards() {
        return allCards;
    }

    public void moveOneCard(List<AgesCard> from, int index, List<AgesCard> to) {

        to.add(from.remove(index));
    }

    public List<AgesCard> getCardRow() {
        return 卡牌列;
    }

    public List<AgesCard> get時代A內政牌() {
        return 時代A內政牌;
    }

    public List<AgesCard> get時代I內政牌() {
        return 時代I內政牌;
    }

    public List<AgesCard> get時代II內政牌() {
        return 時代II內政牌;
    }

    public List<AgesCard> get時代III內政牌() {
        return 時代III內政牌;
    }

    public List<AgesCard> get時代A軍事牌() {
        return 時代A軍事牌;
    }

    public AgesCard getCardByName(List<AgesCard> list, String name) {
        //   List<Card> list=new List<>();
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getName().equals(name)) {
                return list.get(k);
            }
        }
        return null;
    }

    public List<AgesCard> get時代I軍事牌() {
        return 時代I軍事牌;
    }

    public List<AgesCard> get時代II軍事牌() {
        return 時代II軍事牌;
    }

    public List<AgesCard> get時代III軍事牌() {
        return 時代III軍事牌;
    }

    public List<AgesCard> get未來事件() {
        return 未來事件;
    }

    public List<AgesCard> get當前事件() {
        return 當前事件;
    }

    public FieldPlayer getP1() {
        return p1;
    }

    public FieldPlayer getP2() {
        return p2;
    }

    /**
     * 5/15 17:15, by Mark
     */
    public void produce() {
        getCurrentPlayer().produce文化();
        getCurrentPlayer().produce礦山();
        getCurrentPlayer().produce科技();
        getCurrentPlayer().produce農場();
    }

    public FieldPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(FieldPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    public FieldPlayer getCurrentPlayer() {
//        return currentPlayer;
//    }
    public Points getRound() {
        return round;
    }

    public List<AgesCard> getAgeCivil(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("內政")) {
                if (card.getAge() == age) {
                    newList.add(card);
                    list.remove(card);
                }
            }
        }
        return newList;
    }

    public List<AgesCard> getAgeMilitary(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("軍事")) {
                if (card.getAge() == age) {
                    newList.add(card);
                }
            }
        }
        return newList;
    }

    public void showCardInfo(int id) {
//        System.out.println(" qry card id=" + id);
//        System.out.println(" size=" + qryCards.size());

        for (AgesCard card : qryCards) {
            if (card.getId() == id) {
                System.out.println("編號:" + card.getId());
                System.out.println("卡名:" + card.getName());
                System.out.println("類型:" + card.getCivilMilitary());
                System.out.println("時代:" + card.getAge());
                System.out.println("右上:" + card.getTag());
                System.out.println("行動:" + card.getAction());
                System.out.println("成本:" + card.getIconPoints());
                System.out.println("效果:" + card.getEffect());
                System.out.println(card.toString());

//                System.out.println(card.getName());
                return;
            }
        }
    }

    public Field() {
        initField();
    }

    public void reset() {
        initField();
        System.out.println(" Field has been reset!");
    }

    private void initField() {
        //
        round = new Points("回合");

        //
        p1 = new FieldPlayer("max");
        p2 = new FieldPlayer("amy");
        allPlayers = new ArrayList<>();
        allPlayers.add(p1);
        allPlayers.add(p2);
        currentPlayer = p1;

        //
        cardFactory = new AgesCardFactory();
        allCards = cardFactory.getEntireList();
        qryCards = cardFactory.getEntireList();

        //
        卡牌列 = new ArrayList<>();
        未來事件 = new ArrayList<>();
        當前事件 = new ArrayList<>();

        //
        //
        //
        時代A內政牌 = cardFactory.getAgeCivil(0);
        時代I內政牌 = cardFactory.getAgeCivil(1);
        時代II內政牌 = cardFactory.getAgeCivil(2);
        時代III內政牌 = cardFactory.getAgeCivil(3);
        時代A軍事牌 = cardFactory.getAgeMilitary(0);
        時代I軍事牌 = cardFactory.getAgeMilitary(1);
        時代II軍事牌 = cardFactory.getAgeMilitary(2);
        時代III軍事牌 = cardFactory.getAgeMilitary(3);

        //
        // Shuffle
        //
        Collections.shuffle(時代A內政牌);
        Collections.shuffle(時代A軍事牌);
        Collections.shuffle(時代I內政牌);
        Collections.shuffle(時代I軍事牌);
        Collections.shuffle(時代II內政牌);
        Collections.shuffle(時代II軍事牌);
        Collections.shuffle(時代III內政牌);
        Collections.shuffle(時代III軍事牌);

        //
        // basic 6 cards for each player
        //
        for (FieldPlayer player : allPlayers) {
            player.政府區.add(cardFactory.getCardByName("專制"));
            player.實驗室.add(cardFactory.getCardByName("哲學"));
            player.神廟區.add(cardFactory.getCardByName("宗教"));
            player.農場區.add(cardFactory.getCardByName("農業"));
            player.礦山區.add(cardFactory.getCardByName("青銅"));
            player.步兵區.add(cardFactory.getCardByName("戰士"));

            player.get步兵區().get(0).setTokenYellow(1);
            player.get實驗室().get(0).setTokenYellow(1);
            player.get礦山區().get(0).setTokenYellow(2);
            player.get農場區().get(0).setTokenYellow(2);
            player.get人力庫_黃點().setPoints(18);
            player.get工人區_黃點().setPoints(1);
            player.get資源庫_藍點().setPoints(18);

            //
            player.update回合內政點數回合軍事點數();
        }

    }

    public List<AgesCard> getQryCards() {
        return qryCards;
    }

    public void show(List<AgesCard> list, String title) {

        switch (title) {
            case "卡牌列":
//                System.out.print("\u3000");
//                System.out.print(title + " (" + list.size() + ")");
                System.out.print("卡牌列\u3000");
                if (list.size() == 0) {
                    return;
                }
                System.out.print("(1)");
                for (int k = 0; k <= 4; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
                System.out.print("\n\u3000\u3000\u3000\u3000(2)");
                for (int k = 5; k <= 8; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
                System.out.print("\n\u3000\u3000\u3000\u3000(3)");
                for (int k = 9; k <= 12; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
//                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.print(title + " (" + list.size() + ")");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(2));
                }

        }

    }
//    
//    public void show(int style) {
//        switch (style) {
//            case 0:
//                round.show();
//                卡牌列.show(1);
//                System.out.println("Current Player: " + currentPlayer.name);
//                break;
//            case 1:
//                p1.show(1);
//                break;
//            case 2:
//                p2.show(1);
//                break;
//            case 11:
//                p1.show(2);
//                break;
//            case 22:
//                p2.show(2);
//                break;
//
//            default:
//                show();
//        }
//    }

//    public void show() {
//        round.show();
//        System.out.println("\nCurrent Player: " + currentPlayer.name);
//        show(卡牌列, "卡牌列");
//        show(時代A內政牌, "時代A內政牌");
//        show(時代I內政牌, "時代I內政牌");
//        show(時代II內政牌, "時代II內政牌");
//        show(時代III內政牌, "時代III內政牌");
//        show(時代A軍事牌, "時代A軍事牌");
//        show(時代I軍事牌, "時代I軍事牌");
//        show(時代II軍事牌, "時代II軍事牌");
//        show(時代III軍事牌, "時代III軍事牌");
//        for (FieldPlayer player : allPlayers) {
//            player.show();
//        }
//    }
    public void show(int style) {
        System.out.println("**********************  回合:" + round.getPoints() + "  Current Player: " + currentPlayer.name + " ******************************************************");

        switch (style) {
            case 1:
                show(卡牌列, "卡牌列");
                show(時代A內政牌, "時代A內政牌");
                show(時代I內政牌, "時代I內政牌");
                show(時代II內政牌, "時代II內政牌");
                show(時代III內政牌, "時代III內政牌");
                show(時代A軍事牌, "時代A軍事牌");
                show(時代I軍事牌, "時代I軍事牌");
                show(時代II軍事牌, "時代II軍事牌");
                show(時代III軍事牌, "時代III軍事牌");
                allPlayers.stream().forEach((p) -> {
                    p.show();
                });
                break;
            default:
                show(卡牌列, "卡牌列");
                currentPlayer.show();
        }

    }

    public final class FieldPlayer {

        public String getName() {
            return name;
        }

        public void pay內政點數(int cost) {
            內政點數.addPoints((-1) * cost);
        }

        public Points get內政點數() {
            return 內政點數;
        }

        public Points get軍事點數() {
            return 軍事點數;
        }

        public Points get建築上限() {
            return 建築上限;
        }

        public Points get內政手牌上限() {
            return 內政手牌上限;
        }

        public void init建造中的奇蹟區() {
//            wonderStages = new ArrayList<>();
            AgesCard card = 建造中的奇蹟區.get(0);
//            System.out.println(" WE KNOW CURRENT 建造中的奇蹟區 IS " + card.getName() + " " + card.getIconPoints());

            String cost1 = card.getIconPoints();
            String[] cost2 = cost1.split(":");
            String cost3 = cost2[1];
//            System.out.println(" COST IS " + cost3);
            String[] cost4 = cost3.split("-");

            for (String cost5 : cost4) {
//                System.out.println(" " + cost5);
                int cost6 = Integer.parseInt(cost5);
//                wonderStages.add(cost6);
            }

        }

        public Points get軍事手牌上限() {
            return 軍事手牌上限;
        }

        public Points get殖民點數() {
            return 殖民點數;
        }

        public void produce() {
            produce文化();
            produce礦山();
            produce科技();
            produce農場();

        }

        private void produce文化() {
            get文化().addPoints(get文化生產_當回合().getPoints());
        }

        private void produce農場() {
            for (AgesCard card : 農場區) {
                card.setTokenBlue(card.getTokenBlue() + card.getTokenYellow());
            }
        }

        private void produce礦山() {
            for (AgesCard card : 礦山區) {
                card.setTokenBlue(card.getTokenBlue() + card.getTokenYellow());
            }
        }

        private void produce科技() {
            get科技().addPoints(get科技生產_當回合().getPoints());
        }

        public Points get文化() {
            return 文化;
        }

        public Points get文化生產_當回合() {
            return 文化生產_當回合;
        }

        public Points get科技() {
            return 科技;
        }

        public Points get科技生產_當回合() {
            return 科技生產_當回合;
        }

        public Points get軍力() {
            return 軍力;
        }

        public Points get資源庫_藍點() {
            return 資源庫_藍點;
        }

        public Points get人力庫_黃點() {
            return 人力庫_黃點;
        }

        public Points get笑臉_幸福指數() {
            return 笑臉_幸福指數;
        }

        public Points get工人區_黃點() {
            return 工人區_黃點;
        }

        public List<AgesCard> get領袖區() {
            return 領袖區;
        }

        public List<AgesCard> get政府區() {
            return 政府區;
        }

        public List<AgesCard> get實驗室() {
            return 實驗室;
        }

        public List<AgesCard> get神廟區() {
            return 神廟區;
        }

        public List<AgesCard> get農場區() {
            return 農場區;
        }

        public List<AgesCard> get礦山區() {
            return 礦山區;
        }

        public List<AgesCard> get步兵區() {
            return 步兵區;
        }

        public List<AgesCard> get建造中的奇蹟區() {
            return 建造中的奇蹟區;
        }

        public List<AgesCard> get已完成的奇蹟() {
            return 已完成的奇蹟;
        }

        public List<AgesCard> get殖民領土區() {
            return 殖民領土區;
        }

        public List<AgesCard> get特殊科技區() {
            return 特殊科技區;
        }

        public List<AgesCard> get手牌內政牌區() {
            return 手牌內政牌區;
        }

        public List<AgesCard> get手牌軍事牌區() {
            return 手牌軍事牌區;
        }

        public void setName(String name) {
            this.name = name;
        }

        public FieldPlayer(String str) {
            name = str;
            init();
        }

        public void actBuild(int id) {
//            System.out.println("這是在player裡面的");
//            this.農場區.get(0).setTokenYellow(this.農場區.get(0).getTokenYellow() + 1);

            /*
             ONE BY ONE 
             for (AgesCard card : 農場區) {
             if (card.getId() == id) {
             card.setTokenYellow(card.getTokenYellow() + 1);
             this.工人區_黃點.addPoints(-1);
             //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
             }
             }
             for (AgesCard card : 礦山區) {
             if (card.getId() == id) {
             card.setTokenYellow(card.getTokenYellow() + 1);
             this.工人區_黃點.addPoints(-1);
             //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
             }
             }
             */
            List<AgesCard> buildList = new ArrayList<>();
            buildList.addAll(實驗室);
            buildList.addAll(神廟區);
            buildList.addAll(農場區);
            buildList.addAll(礦山區);
            buildList.addAll(步兵區);
            System.out.println(" checking actBuild, how many cards now?" + buildList.size());
            for (AgesCard card : buildList) {
                if (card.getId() == id) {
                    card.setTokenYellow(card.getTokenYellow() + 1);
                    this.工人區_黃點.addPoints(-1);
                    return;
//                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
                }
            }

            for (AgesCard card : 建造中的奇蹟區) {
//                if (card.getId() == id) {
//                    System.out.println("... to build 建造中的奇蹟區 ONE STAGE");
//                    wonderStages.remove(0);
//        
//                    if (wonderStages.size()==0){
//                    System.out.println("... 奇蹟區 done, move to ...");
//                            moveOneCard(wonderStages, 0, 已完成的奇蹟);
//                    }
//                    
//                    return;
////                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
//                }
            }

            System.out.println("your assigned ID " + id + " IS NOT FOUND???");
        }

        public void act摧毀(int id) {
//            System.out.println("這是在player裡面的");
//            this.農場區.get(0).setTokenYellow(this.農場區.get(0).getTokenYellow() + 1);
            /* OLD STYLE, ONE BY ONE
             for (AgesCard card : 農場區) {
             if (card.getId() == id) {
             card.setTokenYellow(card.getTokenYellow() - 1);
             this.工人區_黃點.addPoints(1);
             //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
             }
             }
             for (AgesCard card : 礦山區) {
             if (card.getId() == id) {
             card.setTokenYellow(card.getTokenYellow() - 1);
             this.工人區_黃點.addPoints(1);
             //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
             }
             }
             */

            List<AgesCard> buildList = new ArrayList<>();
            buildList.addAll(實驗室);
            buildList.addAll(神廟區);
            buildList.addAll(農場區);
            buildList.addAll(礦山區);
            buildList.addAll(步兵區);
            for (AgesCard card : buildList) {
                if (card.getId() == id) {
                    card.setTokenYellow(card.getTokenYellow() - 1);
                    this.工人區_黃點.addPoints(+1);
                    return;
                }
            }

        }

        public void act擴充人口() {
            System.out.println("現在要擴充人口了");
//            this.農場區.get(0).setTokenYellow(this.農場區.get(0).getTokenYellow() + 1);
            this.人力庫_黃點.addPoints(-1);
            this.工人區_黃點.addPoints(1);

        }

        private String name;
        private Points 內政點數;
        private Points 軍事點數;
        private Points 回合內政點數;
        private Points 回合軍事點數;
        private Points 建築上限;
        private Points 內政手牌上限;
        private Points 軍事手牌上限;
        private Points 殖民點數;
        private Points 文化;
        private Points 文化生產_當回合;
        private Points 科技;
        private Points 科技生產_當回合;
        private Points 軍力;
        private Points 資源庫_藍點;
        private Points 人力庫_黃點;
        private Points 笑臉_幸福指數;
        private Points 工人區_黃點;
        private List<AgesCard> 領袖區;
        private List<AgesCard> 政府區;
        private List<AgesCard> 實驗室;
        private List<AgesCard> 神廟區;
        private List<AgesCard> 農場區;
        private List<AgesCard> 礦山區;
        private List<AgesCard> 步兵區;
        private List<AgesCard> 未分類區;
// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立騎兵區、炮兵區、飛機區、劇院區、圖書館區、競技場區
        private List<AgesCard> 騎兵區;
        private List<AgesCard> 炮兵區;
        private List<AgesCard> 飛機區;
        private List<AgesCard> 劇院區;
        private List<AgesCard> 圖書館區;
        private List<AgesCard> 競技場區;

        private List<AgesCard> 建造中的奇蹟區;
//        private List<Integer> wonderStages;

        private List<AgesCard> 已完成的奇蹟;
        private List<AgesCard> 殖民領土區;
        private List<AgesCard> 特殊科技區;
        private List<AgesCard> 手牌內政牌區;
        private List<AgesCard> 手牌軍事牌區;

        public void init() {
            內政點數 = new Points("內政點數");
            軍事點數 = new Points("軍事點數");
            回合內政點數 = new Points("回合內政點數");
            回合軍事點數 = new Points("回合軍事點數");

            建築上限 = new Points("建築上限");
            內政手牌上限 = new Points("內政手牌上限");
            軍事手牌上限 = new Points("軍事手牌上限");
            殖民點數 = new Points("殖民點數");
            文化 = new Points("文化");
            文化生產_當回合 = new Points("文化十");//
            科技 = new Points("科技");
            科技生產_當回合 = new Points("科技十");
            軍力 = new Points("軍力");
            資源庫_藍點 = new Points("資源庫【藍】");
            人力庫_黃點 = new Points("人力庫【黃】");
            笑臉_幸福指數 = new Points("笑臉【】");
            工人區_黃點 = new Points("工人區【黃】");
            領袖區 = new ArrayList<>();
            政府區 = new ArrayList<>();
            實驗室 = new ArrayList<>();
            神廟區 = new ArrayList<>();
            農場區 = new ArrayList<>();
            礦山區 = new ArrayList<>();
            步兵區 = new ArrayList<>();
            未分類區 = new ArrayList<>();
// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立 騎兵區、炮兵區、飛機區、劇院區、圖書館區、競技場區            
            騎兵區 = new ArrayList<>();
            炮兵區 = new ArrayList<>();
            飛機區 = new ArrayList<>();
            劇院區 = new ArrayList<>();
            圖書館區 = new ArrayList<>();
            競技場區 = new ArrayList<>();

            建造中的奇蹟區 = new ArrayList<>();
//            wonderStages = new ArrayList<>();

            已完成的奇蹟 = new ArrayList<>();
            殖民領土區 = new ArrayList<>();
            特殊科技區 = new ArrayList<>();
            手牌內政牌區 = new ArrayList<>();
            手牌軍事牌區 = new ArrayList<>();

        }

        public void update回合內政點數回合軍事點數() {
            int new回合內政點數 = 政府區.get(0).getEffectWhite();
            int new回合軍事點數 = 政府區.get(0).getEffectRed();
//            System.out.println(""+政府區.get(0));
            if (領袖區.size() == 1) {
                AgesCard leader = 領袖區.get(0);
                if (leader.getId() == 1023) {// A漢摩拉比1023-內政行動CA+1 軍事行動MA-1】
                    new回合內政點數++;
                    new回合軍事點數--;
                }
                if (leader.getId() == 1009) { //【A凱薩1009-軍事力量+1 軍事行動 MA+1】
//                    new回合內政點數++;
                    new回合軍事點數++;
                }

            }

            回合內政點數.setPoints(new回合內政點數);
            回合軍事點數.setPoints(new回合軍事點數);

        }

        public void show建造中的奇蹟區Stages() {

            System.out.print("  建造中的奇蹟區Stages ");
//            for (Integer stage : wonderStages) {
//                System.out.print(" " + stage);
//            }
        }

        public void show(List<AgesCard> list, String title) {

            switch (title) {

                case "政府區":
                    System.out.println("  ");
                    System.out.print("  " + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(1));
                    }
                    break;
                case "領袖區":
                    System.out.print("  " + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(101));
                    }
                    break;
                case "建造中的奇蹟區":
                    System.out.print("\n  " + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(102));
                    }
                    break;

                case "實驗室":
                case "神廟區":
                case "農場區":
                case "礦山區":
                case "步兵區":
                    System.out.println("  ");
                    System.out.print("  " + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(8));
                    }
                    break;
                case "手牌內政牌區":
                    System.out.println("  ");
                    System.out.print("" + title + " ");
                    int k = 0;
                    for (AgesCard card : list) {
                        System.out.print("" + (k++) + card.toString(4));
                    }
                    break;
                default:
                    System.out.println("");
                    System.out.print("" + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(4));

                    }
            }

        }

        public void show() {
            System.out.println("\n  === " + name + " ===");
            內政點數.show();
            軍事點數.show();
            建築上限.show();
//            System.out.println("");
            內政手牌上限.show();
            軍事手牌上限.show();
            殖民點數.show();
            System.out.println("");
            文化.show();
            文化生產_當回合.show();
            科技.show();
            科技生產_當回合.show();
            軍力.show();
            System.out.println("");
            資源庫_藍點.show();
            人力庫_黃點.show();
            笑臉_幸福指數.show();
            工人區_黃點.show();
            System.out.println("");
            show(政府區, "政府區");
            show(領袖區, "領袖區");
            回合內政點數.show();
            回合軍事點數.show();

            show(實驗室, "實驗室");
            show(神廟區, "神廟區");
            show(農場區, "農場區");
            show(礦山區, "礦山區");
            show(步兵區, "步兵區");
            show(未分類區, "未分類區");
            show(建造中的奇蹟區, "建造中的奇蹟區");
            show建造中的奇蹟區Stages();
            show(已完成的奇蹟, "已完成的奇蹟");
            show(手牌內政牌區, "手牌內政牌區");
            show(手牌軍事牌區, "手牌軍事牌區");
            System.out.println("");

        }

        public void actPlayCard(int val) {
            if (val > 手牌內政牌區.size() - 1) {
                System.out.println("我無法作出這個動作，我這個位置沒有牌");
                return;
            }
            AgesCard card = this.手牌內政牌區.get(val);

            switch (card.getTag()) {
                case "農場":
                    System.out.println("現在打的是農場牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.農場區);
                    break;
                case "領袖":
                    System.out.println("***REPLACE CURRENT ONE");
//                  
//                    System.out.println("現在打的是領袖牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    while (領袖區.size() > 0) {
                        領袖區.remove(0);
                    }
                    moveOneCard(this.手牌內政牌區, val, this.領袖區);
                    break;
                case "礦山":
//                    System.out.println("現在打的是農場牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.礦山區);
                    break;
                case "實驗室":
//                    System.out.println("現在打的是農場牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.實驗室);
                    break;
                case "神廟":
//                    System.out.println("現在打的是農場牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.神廟區);
                    break;
                case "戰士":
//                    System.out.println("現在打的是農場牌準本要放到農場區");
//                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.步兵區);
                    break;
                case "政府":
                    System.out.println("***REPLACE CURRENT ONE");
//                    System.out.print("" + card.toString(1));
                    while (政府區.size() > 0) {
                        政府區.remove(0);
                    }

                    moveOneCard(this.手牌內政牌區, val, this.政府區);
                    break;
                default:
//                    System.out.println("");
                    System.out.print("" + card.toString(1));
                    moveOneCard(this.手牌內政牌區, val, this.未分類區);
            }

            //
            // 06/16 13:30, by Mark
            //
            update回合內政點數回合軍事點數();
        }

        /**
         *
         * @param p1 from
         * @param p2 to
         */
        public void actUpgrade(int p1, int p2) {

            List<AgesCard> buildList = new ArrayList<>();
            buildList.addAll(實驗室);
            buildList.addAll(神廟區);
            buildList.addAll(農場區);
            buildList.addAll(礦山區);
            buildList.addAll(步兵區);
            System.out.println(" checking 實驗室|神廟區|農場區|礦山區|步兵區, how many cards now? " + buildList.size());
          
            for (AgesCard card : buildList) {
                if (card.getId() == p1) {
                    card.setTokenYellow(card.getTokenYellow() - 1);
                    break;
                }
            }

            for (AgesCard card : buildList) {
                if (card.getId() == p2) {
                    card.setTokenYellow(card.getTokenYellow() + 1);
                    break;
                }
            }

        }

    }
}
