package org.example;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.io.File;

public class Capture_packets_and_save {

    static void Capture_and_save(PcapNetworkInterface device) throws PcapNativeException, NotOpenException {


        System.out.println(device);

        if (device == null) {
            System.out.println("No device chosen.");
            System.exit(1);
        }

       
        int snapshotLength = 65536; 
        int readTimeout = 50; 
        final PcapHandle handle;
        handle = device.openLive(snapshotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, readTimeout);

//      final PcapDumper dumper = handle.dumpOpen("D:\\Final Year Project\\NIDS\\New WinRAR ZIP archive\\Network instrusion Detection\\Legitimate_Features\\Pcaps_Legitimate");
      final PcapDumper dumper = handle.dumpOpen("D:\\Final Year Project\\NIDS\\New WinRAR ZIP archive\\Network instrusion Detection\\Legitimate_Features\\Pcaps_Legitimate.pcap");

        
        PacketListener listener = new PacketListener() {

            @Override
            public void gotPacket(Packet packet) {
               
                System.out.println(handle.getTimestamp());
                System.out.println(packet);


                try {
                    dumper.dump(packet, handle.getTimestamp());
                } catch (NotOpenException e) {
                    e.printStackTrace();
                }
            }
        };

       
        try {
            int maxPackets = 20;
            handle.loop(maxPackets, listener);
        } catch (InterruptedException | NotOpenException e) {
            e.printStackTrace();
        }

        handle.close();
        dumper.close();


    }

}
