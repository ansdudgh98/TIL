/*

#include <stdio.h>
#include <math.h>
struct food {

    char name[100];

    int calories;

};
int calc_total_calroies(struct food array[], int size);

int main(void) {

    struct food food_array[3]= { {
        "hambuger", 900
        }
            , {
        "bulgogi", 500
        }

            , {
        "sushi", 700
    }
    };

    int total = calc_total_calroies(food_array, 3);

    printf("%d\n", total);

    return 0;

}

int calc_total_calroies(struct food array[], int size) {

    int i, total=0;

    for (i=0;i<size;i++) {

        total += array[i].calories;

    }

    return total;

}*/
