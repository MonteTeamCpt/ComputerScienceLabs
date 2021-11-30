import java.io.*;
import java.util.*;

public class Melody
{
	private Queue<Note> symph; 
	
	/**
	 * Initializes symph and adds all of queue's notes into it
	 * @param queue - given Queue of Notes
	 */
	public Melody(Queue<Note> queue)
	{
		symph = new LinkedList<Note>();
		symph.addAll(queue);		
	}

	/**
	 * The total duration of all of the duration of the notes in the queue
	 * @return - the total duration of all the notes in the queue including 
	 * 			 their repeats
	 */
	public String getTotalDuration()
	{
		Double dur = (double) 0;
		Queue<Note> seek = new LinkedList<Note>();
		seek.addAll(symph);
		
		while(!seek.isEmpty())
		{
			Note n = seek.poll();
			if(n.isRepeat())
				dur += (2 * n.getDuration());
			dur += n.getDuration();
		}
		
		return dur + "";
	}

	/**
	 * Properly returns the toString of the Melody showing all of the information
	 * of each note in readable format
	 */
	public String toString()
	{
		String str = "";
		
		Queue<Note> seek = new LinkedList<Note>();
		seek.addAll(symph);
		
		while(!seek.isEmpty())
		{
			Note n = seek.poll();
			str += n.getDuration() + " ";
			if(n.getPitch().equals("R"))
			{
				str += "R " + n.isRepeat();
				return str;
			}
			str += n.getPitch() + " ";
			str += n.getOctave() + " ";
			str += n.getAccidental() + " ";
			str += n.isRepeat();	
		}
		
		return str;
	}
	
	/**
	 * Changes the tempo depending on the on the given tempo by multipying it 
	 * to each of the notes duration
	 * @param newTempo - given ratio of the newTempo compared to old tempo
	 */
	public void changeTempo(double newTempo)
	{
		Queue<Note> seek = new LinkedList<Note>();
		seek.addAll(symph);
		symph.clear();

		while(!seek.isEmpty())
		{
			Note n = seek.poll();
			n.setDuration(n.getDuration()*newTempo);
			symph.add(n);	
		}		
	}

	/**
	 * Goes through the entire queue and reverses all values using a stack
	 */
	public void reverse()
	{
		Stack<Note> rev = new Stack<Note>();
		
		while(!symph.isEmpty())
		{
			rev.push(symph.poll());
		}
		
		while(!rev.empty())
		{
			symph.add(rev.pop());
		}
		
	}

	/**
	 * Retrives all the notes in the queue
	 * @return - symph(all the notes in the melody)
	 */
	public Queue<Note> getNotes()
	{
		return symph;
	}
	
	/**
	 * Add all of melody's notes into symph
	 * @param melody - given set of notes
	 */
	public void append(Melody melody)
	{
		symph.addAll(melody.getNotes());
	}
	
	/**
	 * Plays the whole entire song by going through the whole queue and 
	 * playing each note inclduing their repeats
	 */
	public void play()
	{
		Queue<Note> seek = new LinkedList<Note>();
		seek.addAll(symph);
		
		while(!seek.isEmpty())
		{
			Note n = seek.poll();
			if(n.isRepeat())
			{
				n.play();
				n.play();
			}
			else
				n.play();
		}
		
	}
}
