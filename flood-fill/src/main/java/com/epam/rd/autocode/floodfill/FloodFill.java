package com.epam.rd.autocode.floodfill;

import java.util.ArrayList;

public interface FloodFill {
    void flood(final String map, final FloodLogger logger);

    static FloodFill getInstance() {
        return new FloodFill() {
            @Override
            public void flood(String map, FloodLogger logger) {
                logger.log(map);
                boolean flooded=true;
                char[] charMap = map.toCharArray();
                ArrayList<Integer> waterTiles = new ArrayList<>();

                for (int i=0; i<charMap.length; i++) {
                    if (charMap[i] == WATER){
                        waterTiles.add(i);
                      }
                    else if (charMap[i] == LAND)
                        flooded=false;
                }


                int charsInLine = 0;
                for (int i=0; i<charMap.length; i++){
                    if (charMap[i]=='\n') {
                        charsInLine = i;
                        break;
                    }
                }

                for (int k : waterTiles) {
                    if (k != 0 && charMap[k - 1] != '\n')
                        charMap[k - 1] = WATER;
                    if (k - charsInLine > 0)
                        charMap[k - charsInLine - 1] = WATER;
                    if ((k + 1) < charMap.length && charMap[k + 1] != '\n') {
                        charMap[k + 1] = WATER;
                    }
                    if (k + charsInLine < charMap.length)
                        charMap[k + charsInLine + 1] = WATER;
                }
                map = String.valueOf(charMap);
                if (flooded)
                    return;
                flood(map, logger);
            }
        };
    }


    char LAND = '█';
    char WATER = '░';
}
