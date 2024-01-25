#include <stdio.h>
 
int main()
{
    int fil, col;
 
    printf("\nDimension: ");
    scanf("%d", &fil);
    col = fil;
 
    int m[fil][col];
    int mTemp[fil][col];
 
    for (int i = 0; i < fil; i++)
    {
        printf("\nFila %d:\n", i + 1);
        for (int j = 0; j < col; j++)
        {
            printf("(%d/%d): ", j + 1, col);
            scanf("%d", &m[i][j]);
        }
    }
 
    int t = 0;
    for(int i = fil-1; i >= 0; --i) {
        for(int j = 0; j < col; ++j) {
            mTemp[t][j] = m[j][i];
        }
            t++;
    }
 
    printf("\nMatriz Rotada: \n");
    for (int i = 0; i < fil; i++)
    {
        printf("| ");
        for (int j = 0; j < col; j++)
            printf("%d ", mTemp[i][j]);
 
        printf(" |\n");
    }
 
    return 0;
}
