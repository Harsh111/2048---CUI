import java.util.*;
import java.lang.Math;
class GameEdit
{
    static Scanner sc=new Scanner(System.in);
    static int game[][]=new int[4][4];
    GameEdit()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                game[i][j]=0;
            }
        }
    }
    static void print(int game[][])
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(game[i][j]+" ");
            System.out.println();
        }
    }
    static int randomTileGenerator()
    {
        return Math.random()<0.9?2:4;
    }
    static int randomRowGenerator()
    {
        int x;
        do
        {
            x=(int)(10*Math.random());
            
        }while(x>=4);
        return x;
    }
    static int randomColGenerator()
    {
        int x;
        do
        {
            x=(int)(10*Math.random());
        }while(x>=4);
        return x;
    }
static boolean checkSum (char ch)
    {
        boolean flag=false;
        if(ch=='A')
        {
            for(int i=0;i<4;i++)
            {
                for(int j=1;j<4;j++)
                {
                    if(game[i][j]!=0)
                    {
                    for(int k=j-1; k>=0; k--)
                    {
                        if (game[i][k]!=0)
                        {
                            if (game[i][k]==game[i][j])
                            {
                                flag =true;
                            }
                            else
                            break;

                        }

                    }
                    }
                    
                }
            }
        }
        if(ch=='D')
        {
            for(int i=0;i<4;i++)
            {
                for(int j=2;j>=0;j--)
                {
                    if(game[i][j]!=0)
                    {
                    for (int k=j+1; k<4; k++)
                    {
                        if(game[i][k]!=0)
                        {
                            if (game[i][k]== game[i][j])
                            {
                                flag=true;
                            }
                            else
                            break;

                        }
                        
                    }
                    }
                    
                }
            }
        }
        if(ch=='S')
        {
            for(int i=2;i>=0;i--)
            {
                for(int j=0;j<4;j++)
                {
                    if(game[i][j]!=0)
                    {
                    for(int k=i+1; i<4; i++)
                    {
                        if (game[k][j]!=0)
                        {
                            if (game[k][j]==game[i][j])
                            {
                                flag = true;
                            }
                            else
                            break;

                        }

                    }
                    }
                }
            }
        }
        if(ch=='W')
        {
            for(int i=1;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                    if(game[i][j]!=0)
                    {
                    for(int k=i-1; k>=0; k--)
                    {
                        if (game[k][j]!=0)
                        {
                            if (game[k][j]==game[i][j])
                            {
                                flag = true;
                            }
                            else
                            break;
                        }
                    }
                    }
                    
                }
            }
        }
        return flag;
    }
    static boolean checkEndGame()
    {
        boolean flag=true;
        for(int i=0; i<4;i++)
        {
            for(int j=0; j<4; j++)
            {
                if (game[i][j]==0)
                {
                    flag=false;
                    break;
                }
            }
        }
        if (flag==true)
        {
            if (!(checkSum('W')))
            {
                if (!(checkSum('S')))
                {
                    if(!(checkSum('D')))
                    {
                        if (!checkSum('A'))
                        {
                        }
                        else
                        flag = false;
                    }
                    else
                    flag= false;
                }
                else
                flag = false;
            }
            flag= false;
        }
        return flag;
    }
    static void addUp()
    {
        for(int j=0; j<4; j++)
        {
            for(int i=1; i<4; i++)
            {
                if(game[i][j]!=0)
                {
                    for(int k=i-1; k>=0; k--)
                    {
                        if(game[k][j]!=0)
                        {
                            if(game[k][j]==game[i][j])
                            {
                                game[k][j]+=game[i][j];
                                game[i][j]=0;
                                moveUp(j);
                            }
                            else
                            break;
                        }
                    }
                }
            }
            moveUp(j);
        }
    }
    
    static void moveUp(int q)
    {int k;
        for(int i=1; i<4; i++)
        {boolean flag=false;
            if(game[i][q]!=0)
            {
                for(k=i-1; k>=0; k--)
                {
                    if(game[k][q]!=0)
                    {
                        game[k+1][q]=game[i][q];
                        if(k+1!=i)
                        {
                            game[i][q]=0;
                        }
                        flag=true;
                        break;
                    }
                }
                if(flag==false)
                {
                    game[k+1][q]=game[i][q];
                    game[i][q]=0;
                }
            }
        }
    }
    static void addDown()
    {
        for(int j=0; j<4; j++)
        {
            for(int i=2; i>=0; i--)
            {
                if(game[i][j]!=0)
                {
                    for(int k=i+1; k<4; k++)
                    {
                        if(game[k][j]!=0)
                        {
                            if(game[k][j]==game[i][j])
                            {
                                game[k][j]+=game[i][j];
                                game[i][j]=0;
                                moveDown(j);
                            }
                            else
                            break;
                        }
                    }
                }
            }
            moveDown(j);
        }
    }
    
    static void moveDown(int q)
    {int k;
        for(int i=2; i>=0; i--)
        {boolean flag=false;
            if(game[i][q]!=0)
            {
                for(k=i+1; k<4; k++)
                {
                    if(game[k][q]!=0)
                    {
                        game[k-1][q]=game[i][q];
                        if(k-1!=i)
                        {
                            game[i][q]=0;
                        }
                        flag=true;
                        break;
                    }
                }
                if(flag==false)
                {
                    game[k-1][q]=game[i][q];
                    game[i][q]=0;
                }
            }
        }
    }
     static void addRight()
    {
        for(int i=0; i<4; i++)
        {
            for(int j=2; j>=0; j--)
            {
                if(game[i][j]!=0)
                {
                    for(int k=j+1; k<4; k++)
                    {
                        if(game[i][k]!=0)
                        {
                            if(game[i][k]==game[i][j])
                            {
                                game[i][k]+=game[i][j];
                                game[i][j]=0;
                                moveRight(i);
                            }
                            else
                            break;
                        }
                    }
                }
            }
            moveRight(i);
        }
    }
    
    static void moveRight(int q)
    {int k;
        for(int j=2; j>=0; j--)
        {boolean flag=false;
            if(game[q][j]!=0)
            {
                for(k=j+1; k<4; k++)
                {
                    if(game[q][k]!=0)
                    {
                        game[q][k-1]=game[q][j];
                        if(k-1!=j)
                        {
                            game[q][j]=0;
                        }
                        flag=true;
                        break;
                    }
                }
                if(flag==false)
                {
                    game[q][k-1]=game[q][j];
                    game[q][j]=0;
                }
            }
        }
    }   
    static void addLeft()
    {
        for(int i=0; i<4; i++)
        {
            for(int j=1; j<4; j++)
            {
                if(game[i][j]!=0)
                {
                    for(int k=i-1; k>=0; k--)
                    {
                        if(game[k][j]!=0)
                        {
                            if(game[k][j]==game[i][j])
                            {
                                game[k][j]+=game[i][j];
                                game[i][j]=0;
                                moveLeft(i);
                            }
                            else
                            break;
                        }
                    }
                }
            }
            moveLeft(i);
        }
    }
    
    static void moveLeft(int q)
    {int k;
        for(int j=1; j<4; j++)
        {boolean flag=false;
            if(game[q][j]!=0)
            {
                for(k=j-1; k>=0; k--)
                {
                    if(game[q][k]!=0)
                    {
                        game[q][k+1]=game[q][j];
                        if(k+1!=j)
                        {
                            game[q][j]=0;
                        }
                        flag=true;
                        break;
                    }
                }
                if(flag==false)
                {
                    game[q][k+1]=game[q][j];
                    game[q][j]=0;
                }
            }
        }
    }                
    
    public static void main()
    {
            
            int r=randomRowGenerator();
            int c=randomColGenerator();
            int t=randomTileGenerator();
            game[r][c]=t;
            print(game);
        while (!checkEndGame())
        {
            System.out.println("W for up, S for down, A for left, D for right");
            char ch=(sc.next()).charAt(0);
            switch(ch)
                {
                    case('W'):
                    {
                        addUp();
                    }
                    break;
                    case('S'):
                    {
                        addDown();
                    }
                    break;
                    case('A'):
                    {
                        addLeft();
                    }
                    break;
                    case('D'):
                    {
                        addRight();
                    }
                    break;
                }
                do
                {
                r=randomRowGenerator();
                c=randomColGenerator();
                t=randomTileGenerator();    
                }while(game[r][c]!=0);
                game[r][c]=t;
                //System.out.println('\f');
                print(game);
        }
        }
            
    
    }