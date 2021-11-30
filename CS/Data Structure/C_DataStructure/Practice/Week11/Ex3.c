#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 50

typedef struct GraphType {
    int n;
    char adj_mat[MAX_VERTICES][MAX_VERTICES];
    int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;


int parent[MAX_VERTICES];


void init(GraphType* g)
{
    int r, c;
    g->n = 0;
    for (r = 0; r<MAX_VERTICES; r++)
        for (c = 0; c<MAX_VERTICES; c++)
            g->adj_mat[r][c] = '0';
}

void insert_vertex(GraphType* g, int v)
{
    if (((g->n) + 1) > MAX_VERTICES) {
        fprintf(stderr, "그래프 정점:개수 초과");
        return;
    }
    g->n++;
}
void insert_edge(GraphType* g, int start, int end,char c,int weight)
{
    if (start >= g->n || end >= g->n) {
        fprintf(stderr, "그래프 정점 번호 오류");
        return;
    }

    g->adj_mat[start][end] = c;
    g->adj_mat[end][start] = c;
    g->adj_mat[start][end] = weight;
    g->adj_mat[end][start] = weight;

}

void print_adj_mat(GraphType* g)
{
    for (int i = 0; i < g->n; i++) {
        for (int j = 0; j < g->n; j++) {
            printf("%2c", g->adj_mat[i][j]);
        }
        printf("\n");
    }
}

void random_graph(int Vtx,int Eedge){
    GraphType *g;
    g=(GraphType *) malloc(sizeof(GraphType));
    init(g);
    int random1=0;
    int random2=0;

    for(int i=0;i<Vtx;i++){
        insert_vertex(g,i);
    }

    char c = 'A';
    int j = 0;
    while(j<Eedge){
        random1 = rand()%Eedge;
        random2 = rand()%Eedge;
        int weight = rand()%9;
        if((g->adj_mat[random1][random2]=='0')==1){
            insert_edge(g,random1,random2,c,weight);
            j++;
            c++;
        }
    }
    print_adj_mat(g);
}

int compare(const void* a,const void* b){
    struct Edge* x = (struct Edge*)a;
    struct Edge* y = (struct Edge*)b;
    return (x->weight - y -> weight);
}

void set_init(int n){
    for(int i=0;i<n;i++){
        parent[i] = -1;
    }
}

void kruskal(GraphType* g){
    int edge_accepted = 0;
    int uset,vset;
    struct Edge e;

    set_init(g->n);
    qsort(g->edges,g->n,sizeof(struct Edge),compare);

    printf("크루스칼 최초 신장 트리 알고리즘\n");
    int i=0;
    while (edge_accepted<(g->n-1)){
        e = g->edges[i];
        uset= set_find(e.start);
        vset = set_find(e.end);
        if(uset!=vset){
            printf("간선 (%d,%d) %d 선택 \n",e.start,e.end,e.weight);
            edge_accepted++;
            set_union(uset,vset);
        }
        i++;
    }

}

int main(void){

    int edgenum;
    int vertex;

    printf("정점의 수를 입력해주세요:");
    scanf("%d",&vertex);


    printf("간선수를 입력해주세요.");
    scanf("%d",&edgenum);


    random_graph(vertex,edgenum);


}