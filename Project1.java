package edu.pdx.cs410J.saras3;

import edu.pdx.cs410J.AbstractAppointmentBook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.System.exit;

/**
 * This class creates an instance of Appointment and AppointmentBook
 * and does error checking for their members respectively
 *
 * @author Saraswathi Datar
 */
public class Project1 {
  public static boolean Parse = FALSE;

  static Appointment appt = new Appointment();
  static AppointmentBook appt_book = new AppointmentBook();

  /**
   * This method checks if the user has entered a valid date and time
   * by defining a regular expression pattern to which the user input
   * need to conform. If the input does not match the pattern defined,
   * then an exception is thrown
   * @param regex   the regex that is compared to check validity
   * @param i       index in argument list
   * @return        <code>true</code> if input matches pattern.
   *                <code>false</code> otherwise.
   */
  public static boolean validate_date_time(String regex, int i){
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(appt.argsList.get(i));
    return matcher.matches();
  }

  /**
   * This method checks for total number of valid arguments and checks
   * each argument in the argslist to check if they are in the correct
   * format, else throw an exception.
   * @return        <code>true</code> if an argument is empty or in
   *                 incorrect format then throws exception and error
   *                 flag is set to TRUE.
   *                <code>false</code> otherwise error flag is FALSE
   */

  public static boolean error_check() {
    boolean error = FALSE;

    if (appt.argsList.size() != 6) {
      throw new IllegalArgumentException("Invalid number of arguments\n");//AK_ RAM: Add exception
    } else {
      for (int i = 0; i < appt.argsList.size(); i++) {
        switch (i) {
          case 0:
            if (appt.argsList.get(i).trim().length() == 0) {
              error = TRUE;
              throw new IllegalArgumentException("Name is empty\n");
            }
            break;
          case 1:
            if (appt.argsList.get(i).trim().length() == 0) {
              error = TRUE;
              throw new IllegalArgumentException("Description is empty\n");
            }
            break;
          case 2:
            if((validate_date_time("^(1[0-2]|0[1-9]|[1-9])/(3[01]|[12][0-9]|0[1-9]|[1-9])/[0-9]{4}$", i)) == FALSE){
              error = TRUE;
              throw new IllegalArgumentException("Enter Begin-month/date/year in valid format: mm/dd/yyyy\n");
            }
            break;
          case 3:
            if((validate_date_time("^([01]?[0-9]|2[0-3]):[0-5][0-9]$", i)) == FALSE){
              error = TRUE;
              throw new IllegalArgumentException("Enter Begin-Time in valid format: hh:mm\n");
            }
            break;
          case 4:
            if((validate_date_time("^(1[0-2]|0[1-9]|[1-9])/(3[01]|[12][0-9]|0[1-9]|[1-9])/[0-9]{4}$", i)) == FALSE){
              error = TRUE;
              throw new IllegalArgumentException("Enter End-month/date/year in valid format: mm/dd/yyyy\n");
            }
            break;
          case 5:
            if((validate_date_time("^([01]?[0-9]|2[0-3]):[0-5][0-9]$", i)) == FALSE){
              error = TRUE;
              throw new IllegalArgumentException("Enter End-Time in valid format: hh:mm\n");
            }
            break;
        }
      }
    }
    return error;
  }

  /**
   * This class is the main class for the CS410J appointment book Project. If the
   * first character of an argument is - then it checks to see if it is print or
   * README. If the option is -print then we set a flag to print the arguments
   * once they are parsed successfully and if it is -README then the code prints
   * README and exits accordingly. The rest of the arguments are added to an
   * argslist. This methods also instantiates Appointment and AppointmentBook, and
   * if error_check() returns false (meaning no error) then appointment is added
   * to the appointment book and details of appointment are printed (as required)
   *
   * @param args        Arguments from Commandline read as Strings
   */
  public static void main(String[] args) {
    Class c = AbstractAppointmentBook.class;// Refer to one of Dave's classes so that we can be sure it is on the classpath
    for (int i = 0; i < args.length; i++) {
      switch (args[i].charAt(0)) {
        case '-':
          if ((i == 0) || (i == 1)) {
            if (args[i].compareTo("-print") == 0) {
              Parse = TRUE;
            } else if (args[i].compareTo("-README") == 0) {
              System.out.println("**README**\n Name: Saraswathi Govind Datar \n Project: CS410J-Project1 \n " +
                      "Description: The following application is designed to create an Appointment book for a given Owner, " +
                      "and add an Appointment to it (with specific details of appointment's Begin date & time, End date & time" +
                      ", and a relevant description describing the appointment)\n ");
              exit(0);
            } else {
              throw new IllegalArgumentException("This is Not a valid option: " + args[i]);//for ex: -hello -README
            }
          } else {
            appt.argsList.add(args[i]);
          }
          break;
        default:
          appt.argsList.add(args[i]);
          break;
      }
    }


    if(error_check() == FALSE){
      appt_book.Ownername = appt.argsList.get(0);
      appt_book.addAppointment(appt);
      if (Parse == TRUE) {
        System.out.println(appt_book.toString());
        System.out.println(appt.toString());
      }
    }else{
      System.out.println("Error in command line arguments\n");
      exit(1);
    }

   System.exit(1);

  }
}
