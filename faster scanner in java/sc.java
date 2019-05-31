import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;


class sc implements Iterator<String>
{
  
  BufferedReader buffer;
  StringTokenizer token;
  
  public sc()
  {
    buffer = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public sc(InputStream in)
  {
    buffer = new BufferedReader(new InputStreamReader(in));
  }
  
  public sc(File f) throws FileNotFoundException
  {
    buffer = new BufferedReader(new FileReader(f));
  }
  
  public boolean hasNext()
  {
    while(token == null || !token.hasMoreElements())
    {
      try
      {
        token = new StringTokenizer(buffer.readLine());
      }catch(IOException e)
      {
        return false;
      }
    }
    return true;
  }
  
  public String next()
  {
    if(hasNext()) 
      return token.nextToken();
    return null;
  }

  @Override
  public void remove()
  {
    return;
  }

  String nextLine()
  {
    if(hasNext()) 
      return token.nextToken("\n");
    return null;
  }
  
  char nextChar()
  {
    return next().charAt(0);
  }
  
  int nextInt()
  {
    return Integer.parseInt(next());
  }

  long nextLong()
  {
    return Long.parseLong(next());
  }
  
  double nextDouble()
  {
    return Double.parseDouble(next());
  }
  
  byte nextByte()
  {
    return Byte.parseByte(next());
  }
  
}