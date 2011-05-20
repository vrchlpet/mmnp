

package org.cvut.vrchlpet.MCore.core;

import java.awt.Color;


/**
 *
 * Vycet datovych typu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public enum MData{

        STRING {
            @Override
            public String toString() {
                return "String";
            }

            @Override
            public Class<String> getDataClass() {
                return String.class;
            }
            
            @Override
            public String getDefault() {
                return "";
            }
        },
        BOOLEAN {
            @Override
            public String toString() {
                return "Boolean";
            }

            @Override
            public Class<Boolean> getDataClass() {
                return Boolean.class;
            }
            
            @Override
            public Boolean getDefault() {
                return true;
            }
        },
        DOUBLE {
            @Override
            public String toString() {
                return "Double";
            }

            @Override
            public Class<Double> getDataClass() {
                return Double.class;
            }
            
            @Override
            public Double getDefault() {
                return 0.0;
            }
        },
        INTEGER {
            @Override
            public String toString() {
                return "Integer";
            }

            @Override
            public Class<Integer> getDataClass() {
                return Integer.class;
            }
            
            @Override
            public Integer getDefault() {
                return 0;
            }
        },
        CHARACTER {
            @Override
            public String toString() {
                return "Character";
            }

            @Override
            public Class<Character> getDataClass() {
                return Character.class;
            }
            
            @Override
            public Character getDefault() {
                return ' ';
            }
        },
        COLOR {
            @Override
            public String toString() {
                return "Color";
            }

            @Override
            public Class<Color> getDataClass() {
                return Color.class;
            }
            
            @Override
            public Color getDefault() {
                return new Color(255,255,255);
            }
        };



        public static MData getType(String s) {
            MData [] val = values();
            
            for ( int i = 0; i < val.length; i++) {
                if ( s.equals(val[i].toString()))
                    return val[i];
            }
            return STRING;
        }

        public static MData getType(Class<Object> clazz) {
            MData [] val = values();

            for ( int i = 0; i < val.length; i++) {
                if ( clazz == val[i].getDataClass())
                    return val[i];
            }
            return STRING;
        }


        @Override
        public abstract String toString();
        public abstract Class<? extends Object> getDataClass();
        public abstract Object getDefault();
    
}
