package slidingwindow;

import java.util.*;

/**
 * For problem statement @see <a href="https://leetcode.com/problems/repeated-dna-sequences/description/">Repeated DNA Sequences</a>
 */

/**
 * 1) Encode DNA sequence in s by converting 'A', 'C', 'G', and 'T' into numbers (0, 1, 2, 3) for easier computation.
 * 2) Compute the rolling hash for the first window containing a 10-letter substring and store it in a set to check repetition.
 * 3) Move the window one step forward and compute the hash of the new window. Store this new hash in the set.
 * 4) Store the corresponding substring in the result if the calculated hash appears again.
 * 5) Once the entire string has been traversed, return the result containing all the repeating a 10-letter long sequence.
 */
// Solution using Rolling hash - polynomial
class RepeatedDNASeq {

    public List<String> findRepeatedDnaSequences(String s) {
        // Handle Invalid inputs
        if (s == null || s.length() < 10) {
            return List.of();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        Map<Long, String> seenHash = new HashMap<>();
        Set<String> result = new HashSet<>();
        char[] ch = s.toCharArray();
        Long hash = 0L;
        int sum = 0;
        int[] encodedSeq = new int[ch.length];

        long base = 31L;

        long modulo = 1000000007;

        for (int i = 0; i < ch.length; i++) {
            encodedSeq[i] = map.get(ch[i]);
        }

        long powerBase = 1L;

        for (int i = 1; i < 10; i++) {
            powerBase = (powerBase * base) % modulo;
        }

        for (int i = 0; i < 10; i++) {
            hash = ((hash * base) + encodedSeq[i]) % modulo;
        }

        seenHash.put(hash, s.substring(0, 10));

        for (int i = 10; i < ch.length; i++) {
            // To avoid negative values.
            hash = (hash - ((powerBase * encodedSeq[i - 10]) % modulo) + modulo) % modulo;
            hash = (hash * base + encodedSeq[i]) % modulo;
            String substring = s.substring(i - 10 + 1, i + 1);
            if (seenHash.containsKey(hash)) {
                result.add(seenHash.get(hash));
            } else {
                seenHash.put(hash, substring);
            }
        }

        return new ArrayList<>(result);
    }


    /**
     * This solution handles hash collision scenarios as well in the code.
     */
    public List<String> findRepeatedDnaSequencesHandlingCollisions(String s) {
        // Handle Invalid inputs
        if (s == null || s.length() < 10) {
            return List.of();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        Map<Long, List<String>> seenHash = new HashMap<>();
        Set<String> result = new HashSet<>();
        char[] ch = s.toCharArray();
        Long hash = 0L;
        int sum = 0;
        int[] encodedSeq = new int[ch.length];

        long base = 31L;

        long modulo = 1000000007;

        for (int i = 0; i < ch.length; i++) {
            encodedSeq[i] = map.get(ch[i]);
        }

        long powerBase = 1L;

        for (int i = 1; i < 10; i++) {
            powerBase = (powerBase * base) % modulo;
        }

        for (int i = 0; i < 10; i++) {
            hash = ((hash * base) + encodedSeq[i]) % modulo;
        }


        List<String> strs = new ArrayList<>();
        strs.add(s.substring(0, 10));

        seenHash.put(hash, strs);

        for (int i = 10; i < ch.length; i++) {
            // To avoid negative values.
            hash = (hash - ((powerBase * encodedSeq[i - 10]) % modulo) + modulo) % modulo;
            hash = (hash * base + encodedSeq[i]) % modulo;
            String substring = s.substring(i - 10 + 1, i + 1);
            if (seenHash.containsKey(hash)) {
                if (seenHash.get(hash).contains(substring)) {
                    result.add(substring);
                } else {
                    List<String> matchingStrings = seenHash.get(hash);
                    matchingStrings.add(substring);
                    seenHash.put(hash, matchingStrings);
                }
            } else {
                List<String> matchingStrings = new ArrayList<>();
                matchingStrings.add(substring);
                seenHash.put(hash, matchingStrings);
            }
        }

        return new ArrayList<>(result);
    }


}