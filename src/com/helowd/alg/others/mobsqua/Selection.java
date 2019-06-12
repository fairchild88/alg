package com.helowd.alg.others.mobsqua;

import java.io.IOException;
import java.util.*;

/**
 * Created by fei on 2018/10/29.
 */
public class Selection {

    public static String electionWinner(String[] votes) {
        if ( votes == null) {
            throw new IllegalArgumentException("wrong args");
        }

        List<String> votesList = Arrays.asList(votes);
        Collections.sort(votesList, ALPHABET_ORDER);

        int maxCount = 0;
        String maxVote = null;
        int voteCount = 0;
        String curVote = null;
        for (String vote : votesList) {
            if (curVote == null || !curVote.equals(vote)) {
                if (voteCount >= maxCount) {
                    maxCount = voteCount;
                    maxVote = curVote;
                }
                voteCount = 1;
            } else {
                voteCount++;
            }
            curVote = vote;
        }

        if (voteCount >= maxCount) {
            maxVote = curVote;
        }

        return maxVote;
    }

    private static Comparator<String> ALPHABET_ORDER = (o1, o2) -> {
        int result = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
        return result == 0 ? o1.compareTo(o2) : result;
    };

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Selection selection = new Selection();
        System.out.println(selection.electionWinner(new String[]{"A", "A", "B", "B", "A", "C"}));
        System.out.println(selection.electionWinner(new String[]{"Alice", "Allison", "Alice", "Allison", "Ashley", "Ashley"}));
    }
}
