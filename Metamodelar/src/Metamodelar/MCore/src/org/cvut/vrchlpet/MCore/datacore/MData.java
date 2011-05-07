

package org.cvut.vrchlpet.MCore.datacore;

import java.awt.Color;
import java.util.Date;


/**
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
            public Class getDataClass() {
                return String.class;
            }
        },
        BOOLEAN {
            @Override
            public String toString() {
                return "Boolean";
            }

            @Override
            public Class getDataClass() {
                return Boolean.class;
            }
        },
        UNDEFINED {
            @Override
            public String toString() {
                return "Undefined";
            }

            @Override
            public Class getDataClass() {
                return Object.class;
            }
        },
        DOUBLE {
            @Override
            public String toString() {
                return "Double";
            }

            @Override
            public Class getDataClass() {
                return Double.class;
            }
        },
        INTEGER {
            @Override
            public String toString() {
                return "Integer";
            }

            @Override
            public Class getDataClass() {
                return Integer.class;
            }
        },
        CHARACTER {
            @Override
            public String toString() {
                return "Character";
            }

            @Override
            public Class getDataClass() {
                return Character.class;
            }
        },
        DATE {
            @Override
            public String toString() {
                return "Date";
            }

            @Override
            public Class getDataClass() {
                return Date.class;
            }
        },
        COLOR {
            @Override
            public String toString() {
                return "Color";
            }

            @Override
            public Class getDataClass() {
                return Color.class;
            }
        };



        public static MData getType(String s) {
            MData [] val = values();
            
            for ( int i = 0; i < val.length; i++) {
                if ( s.equals(val[i].toString()))
                    return val[i];
            }
            return UNDEFINED;
        }

        public static MData getType(Class clazz) {
            MData [] val = values();

            for ( int i = 0; i < val.length; i++) {
                if ( clazz == val[i].getDataClass())
                    return val[i];
            }
            return UNDEFINED;
        }


        @Override
        public abstract String toString();
        public abstract Class getDataClass();
    
}
