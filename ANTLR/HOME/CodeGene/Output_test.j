.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.method public <init>()V
    .limit stack 32
    .limit locals 1
    aload_0
    invokespecial java/lang/Object/<init>()V
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 7
.line 2
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 1
    aload 1
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 2
    aload 2
    ldc "one"
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2
    ldc "two"
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 3
    aload 3
    ldc "three"
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 3
    ldc "four"
    bipush 4
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 3
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 3
    aload 1
    ldc "dic1"
    ;debug
    invokevirtual java/util/HashMap/get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    dup
    ldc "two"
    swap
    ldc "two"
    invokevirtual java/util/HashMap/get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    sipush 203
    imul
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 4
    aload 1
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 4
    Label1:
    aload 4
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label2
    aload 4
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 5
.line 5
    aload_0
    iload 5
    invokevirtual HOME/Print(I)I
    pop
    goto Label1
    Label2:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 1
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

.method public Print(I)I
    .limit stack 11
    .limit locals 2
.line 20
    iload 1
    ireturn
.end method

