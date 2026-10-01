// Last updated: 10/1/2026, 2:56:40 PM
import java.util.Arrays;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int width = n + 2;
        int totalCells = (m + 2) * width;

        byte[] type = new byte[totalCells];
        int[] litter = new int[totalCells];
        int lCount = 0;
        int startPos = -1;

        for (int i = 0; i < m; i++) {
            String row = classroom[i];
            for (int j = 0; j < n; j++) {
                char c = row.charAt(j);
                int pos = (i + 1) * width + (j + 1);
                if (c == 'X') {
                    type[pos] = 0;
                } else if (c == '.') {
                    type[pos] = 1;
                } else if (c == 'S') {
                    type[pos] = 1;
                    startPos = pos;
                } else if (c == 'L') {
                    type[pos] = 1;
                    litter[pos] = 1 << lCount;
                    lCount++;
                } else if (c == 'R') {
                    type[pos] = 2;
                }
            }
        }

        if (lCount == 0) {
            return 0;
        }
        
        int targetMask = (1 << lCount) - 1;

        int[] currQ = new int[524288];
        int[] nextQ = new int[524288];
        byte[] maxE = new byte[524288];
        int[] lastAdded = new int[524288];

        Arrays.fill(maxE, (byte) -1);
        
        int currSz = 0;
        currQ[currSz++] = startPos;
        maxE[startPos] = (byte) energy;
        lastAdded[startPos] = 0;

        int moves = 0;

        while (currSz > 0) {
            int nextSz = 0;
            moves++;
            
            for (int i = 0; i < currSz; i++) {
                int state = currQ[i];
                int e = maxE[state];

                if (e == 0) {
                    continue;
                }

                int pos = state & 511;
                int mask = state >> 9;
                int nextE = e - 1;
                
                int npos, t, ne, nmask, nstate;

                npos = pos - width;
                t = type[npos];
                if (t != 0) {
                    ne = (t == 2) ? energy : nextE;
                    nmask = mask | litter[npos];
                    if (nmask == targetMask) return moves;
                    nstate = npos | (nmask << 9);
                    if (ne > maxE[nstate]) {
                        maxE[nstate] = (byte) ne;
                        if (lastAdded[nstate] != moves) {
                            lastAdded[nstate] = moves;
                            nextQ[nextSz++] = nstate;
                        }
                    }
                }

                npos = pos + width;
                t = type[npos];
                if (t != 0) {
                    ne = (t == 2) ? energy : nextE;
                    nmask = mask | litter[npos];
                    if (nmask == targetMask) return moves;
                    nstate = npos | (nmask << 9);
                    if (ne > maxE[nstate]) {
                        maxE[nstate] = (byte) ne;
                        if (lastAdded[nstate] != moves) {
                            lastAdded[nstate] = moves;
                            nextQ[nextSz++] = nstate;
                        }
                    }
                }

                npos = pos - 1;
                t = type[npos];
                if (t != 0) {
                    ne = (t == 2) ? energy : nextE;
                    nmask = mask | litter[npos];
                    if (nmask == targetMask) return moves;
                    nstate = npos | (nmask << 9);
                    if (ne > maxE[nstate]) {
                        maxE[nstate] = (byte) ne;
                        if (lastAdded[nstate] != moves) {
                            lastAdded[nstate] = moves;
                            nextQ[nextSz++] = nstate;
                        }
                    }
                }

                npos = pos + 1;
                t = type[npos];
                if (t != 0) {
                    ne = (t == 2) ? energy : nextE;
                    nmask = mask | litter[npos];
                    if (nmask == targetMask) return moves;
                    nstate = npos | (nmask << 9);
                    if (ne > maxE[nstate]) {
                        maxE[nstate] = (byte) ne;
                        if (lastAdded[nstate] != moves) {
                            lastAdded[nstate] = moves;
                            nextQ[nextSz++] = nstate;
                        }
                    }
                }
            }

            int[] temp = currQ;
            currQ = nextQ;
            nextQ = temp;
            currSz = nextSz;
        }

        return -1;
    }
}