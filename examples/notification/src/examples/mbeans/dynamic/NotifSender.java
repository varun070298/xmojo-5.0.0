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

package examples.mbeans.dynamic;

import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationBroadcaster;
import javax.management.Notification;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

/**
 *	This class is capable of sending Notifications.  By extending the
 *  DynamicServerInfo class, this class is also a DynamicMBean.
 *	@author <a href="mailto:xmojo-support@xmojo.org">XMOJO Team</a>
 *	@version 1.0
 */

public class NotifSender extends DynamicServerInfo implements NotificationBroadcaster {

        /////// Variables declaration ////////

        long seqNum = 1;

        Notification notif = null;

        NotificationBroadcasterSupport nbs =
                new NotificationBroadcasterSupport();


        //////// Constructor definitions ////////

        public NotifSender() {
                super ();
        }

        public NotifSender(String serverName, String serverId,
                boolean serverStarted, int port) {
                super (serverName , serverId , serverStarted , port);
        }

        // Overriding the startService operation. Notification of type Server.started will be sent

        public void startService() {
                super.startService ();

                notif = new Notification ("Server.started" , this.getClass().getName() ,
                        seqNum , System.currentTimeMillis (), "Server successfully started");

                nbs.sendNotification (notif);

                seqNum++ ;
        }

        // Overriding the stopService operation. Notification of type Server.stopped will be sent

        public void stopService() {
                super.stopService ();

                notif = new Notification ("Server.stopped" , this.getClass().getName() ,
                        seqNum , System.currentTimeMillis (), "Server successfully stopped");

                nbs.sendNotification (notif);

                seqNum++ ;
        }

        // Implementing the NotificationBroadCaster

        public void addNotificationListener(NotificationListener lstnr,
                NotificationFilter filter,
                Object obj) throws IllegalArgumentException {
                nbs.addNotificationListener(lstnr, filter, obj);
        }

        public void removeNotificationListener( NotificationListener lstnr)
                throws ListenerNotFoundException {
                nbs.removeNotificationListener(lstnr);
        }

        public MBeanNotificationInfo[] getNotificationInfo() {
                return nbs.getNotificationInfo();
        }
}

