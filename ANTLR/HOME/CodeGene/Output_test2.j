.source                  HOME.java
.class                   public ECHO
.super                   java/lang/Object
 .field public i Ljava/lang/Integer; = 2
 .field public x Ljava/lang/String; = "Hej Verden"


.method public <init>()V
	.limit stack 1
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

.method public echo()V
   .limit stack 4

   getstatic java/lang/System/out Ljava/io/PrintStream;
   getfield ECHO/x Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   return
.end method