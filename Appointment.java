package edu.pdx.cs410J.saras3;

import edu.pdx.cs410J.AbstractAppointment;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an appointment present in an appointment book.
 * Each appointment has a description , and Begin & End time
 * @author Saraswathi Datar
 */


public class Appointment extends AbstractAppointment {
  List<String> argsList = new ArrayList<String>();

  /**
   * Returns a String describing the Begin date and time of
   * this particular appointment stored in argsList
   */
  @Override
  public String getBeginTimeString() {
    String begintime;
    begintime = argsList.get(2) + " " + argsList.get(3);
    return begintime;
  }

  /**
   * Returns a String describing the End date and time of
   * this particular appointment stored in argsList
   */
  @Override
  public String getEndTimeString() {
    String endtime;
    endtime = argsList.get(4) + " " + argsList.get(5);
    return endtime;
  }

  /**
   * Returns a description of this particular appointment
   * stored in argsList
   */
  @Override
  public String getDescription() {
    return argsList.get(1);
  }
}
