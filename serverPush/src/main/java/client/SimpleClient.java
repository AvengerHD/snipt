package client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created by kekai on 17/7/14.
 */
public class SimpleClient {



    public static void main(String[] args) throws InterruptedException {
        Bootstrap b = new Bootstrap();
        b.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
                        channel.pipeline().addLast(new HttpClientCodec());
                        channel.pipeline().addLast(new ProcessResponseHandler());
                    }
                });

        ChannelFuture f = b.connect("127.0.0.1", 8083).sync();
        f.channel().closeFuture().addListener(ChannelFutureListener.CLOSE);
    }
}
