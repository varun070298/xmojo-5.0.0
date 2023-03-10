/**
 * The XMOJO Project 5
 * Copyright ? 2003 XMOJO.org. All rights reserved.

 * NO WARRANTY

 * BECAUSE THE LIBRARY IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR
 * THE LIBRARY, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN
 * OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES
 * PROVIDE THE LIBRARY "AS IS" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED
 * OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS
 * TO THE QUALITY AND PERFORMANCE OF THE LIBRARY IS WITH YOU. SHOULD THE
 * LIBRARY PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING,
 * REPAIR OR CORRECTION.

 * IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL
 * ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE
 * THE LIBRARY AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY
 * GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE
 * USE OR INABILITY TO USE THE LIBRARY (INCLUDING BUT NOT LIMITED TO LOSS OF
 * DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD
 * PARTIES OR A FAILURE OF THE LIBRARY TO OPERATE WITH ANY OTHER SOFTWARE),
 * EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGES.
**/

package examples.mbeans.standard;

import javax.management.NotificationListener ;
import javax.management.Notification ;

/**
 *	This class is a example for StandardMBean. This class exposes the management
 *	information of a web server.
 *	@author <a href="mailto:xmojo-support@xmojo.org">XMOJO Team</a>
 *	@version 1.0
 */

public class NotifReceiver implements NotifReceiverMBean , NotificationListener
{
	private int num;

	public NotifReceiver()
	{
    }

	// Instrument the required changes to implement the NotifReceiverMBean

	public int getNotificationsReceived( )
	{
		// get the number of notificatons received
		return num;
	}

	// implementing the handleNotification method of NotificationListener interface

	public void handleNotification( Notification notif , Object handback )
	{
		System.out.println("  *************************************************************************** ");
		System.out.println("  **  Notification received !!  Inside handleNotification of NotifReceiver ");
		System.out.println("  **  Notification type : " + notif.getType ( ) );
		System.out.println("  **  Notification sequence number : " + notif.getSequenceNumber ( ) );
		System.out.println("  **  Notification time stamp : " + notif.getTimeStamp ( ) );
		System.out.println("  **  Notification message : " + notif.getMessage ( ) );
		System.out.println("  ************************************************************************** ");
		num++;
	}
}