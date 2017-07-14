package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kekai on 17/7/14.
 */
public class ChunkPublishHandler extends ChannelInboundHandlerAdapter {

    private volatile  boolean flag = true;
    ExecutorService e = Executors.newFixedThreadPool(1);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String currentResponse = "hello";
        HttpResponse content = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        content.headers().add(HttpHeaderNames.TRANSFER_ENCODING, "chunked");
        ctx.writeAndFlush(content);

        if(flag) {
            flag = false;
            e.submit(() -> {
                Thread.sleep(20000);
                while (true) {
                    Thread.sleep(3000);
                    String response = "hello " ;
                    ByteBuf byteBuf = Unpooled.copiedBuffer(response.getBytes());
                    DefaultHttpContent content1 = new DefaultHttpContent(byteBuf);
                    ctx.writeAndFlush(content1);
                }
            });
        }

    }
}
