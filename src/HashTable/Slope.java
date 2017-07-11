package HashTable;

class Slope{
        int x;
        int y;

        public Slope(int x1,int y1){
            x=x;
            y=y;
        }
        @Override
        public boolean equals(Object obj) {
            return x==((Slope) obj).x && y==((Slope) obj).y;
        }
    }