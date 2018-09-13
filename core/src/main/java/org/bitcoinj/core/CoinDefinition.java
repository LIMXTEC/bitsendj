package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final String coinName = "BitSend";
    public static final String coinNameV2 = "Bitsend";
    public static final String coinTicker = "BSD";
    public static final String coinURIScheme = "bitsend";
    public static final String cryptsyMarketId = "309";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[i]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/bsd/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://chainz.cryptoid.info/bsd/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address.dws?";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx.dws?";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block.dws?";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "";

    public static final String DONATION_ADDRESS = "i6yaT9wUGDqCk7abqGyQi77p6n7ZFdkmiX";


    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(6 * 24 * 60 * 60);
    public static final int TARGET_SPACING = (int)(5 * 60);
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }

    public static int spendableCoinbaseDepth = 25;
    public static final long MAX_COINS = 525000000;

    public static final long DEFAULT_MIN_TX_FEE = 5000;
    public static final long DUST_LIMIT = 500;

    public static final long INSTANTX_FEE = 1000000;

    public static final int PROTOCOL_VERSION = 70084;
    public static final int MIN_PROTOCOL_VERSION = 70084;

    public static final int BLOCK_CURRENTVERSION = 3;
    public static final int MAX_BLOCK_SIZE = 10000000;

    public static final boolean supportsBloomFiltering = true;

    public static final int Port = 8886;
    public static final int TestPort = 8885;

    //
    //  Production
    //
    public static final int AddressHeader = 102;
    public static final int p2shHeader = 5;
    public static final boolean allowBitcoinPrivateKey = false;
    public static final int dumpedPrivateKeyHeader = 128;
    public static final long PacketMagic = 0xa3d5c2f9;

    // Forks
    static public long FORK_X17 = 1477958400; // BitSend PoW Hardfork, 11/01/2016 @ 12:00am (UTC)

    static public long genesisBlockDifficultyTarget = 0x1e0ffff0L;
    static public long genesisBlockTime = 1402097469L;
    static public long genesisBlockNonce = 34784351;
    static public String genesisHash = "0000012e1b8843ac9ce8c18603658eaf8895f99d3f5e7e1b7b1686f35e3c087a";
    static public String genesisMerkleRoot = "c0c4f68994b78c31b6c7d7a8a895b5a085857adfbb73699bcfe5a247a357df57";
    static public int genesisBlockValue = 100;

    static public String genesisTxInBytes = "04ffff001d01043b6c696d65636f696e58206f667265636520616d706c69612067616d6120646520736572766963696f732079206d656a6f7261732070617261207469";
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    static public String[] dnsSeeds = new String[] {
            "seed.mybitsend.com",
            "seed1.mybitsend.com",
            "37.120.186.85",
            "37.120.190.76",
    };

    public static int minBroadcastConnections = 0;

    public static final Coin GetBlockReward(int height)
    {
        int nSubsidy;

        if (height == 1)
            nSubsidy = 1306400;
        else if (height < 239000) // main.cpp, (FORKX17_Main_Net-1000)
            nSubsidy = 50;
        else if (height < 7869744) // main.cpp, (FORKX17_Main_Net*33)-50256)
            nSubsidy = 25;
        else
            nSubsidy = 1; // should be 0.1 !!!   

        return Coin.valueOf(nSubsidy, 0);
    }

    public static int subsidyDecreaseBlockCount = 210000;

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);

    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.bitsend.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.bitsend.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.bitsend.unittest";

    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(      0, Sha256Hash.wrap("0000012e1b8843ac9ce8c18603658eaf8895f99d3f5e7e1b7b1686f35e3c087a"));
        checkpoints.put(  10000, Sha256Hash.wrap("0000000006c1a1573ca82ad24789c10a36535cf085f201122f1d112a88841271"));
        checkpoints.put(  15790, Sha256Hash.wrap("000000004151f93a4012545309d4bbcac5f2977dea643a178c4bec1310e6c086"));
        checkpoints.put(  21190, Sha256Hash.wrap("000000002a798fd88d0ce270cad1c217aceea236b573c68cfd02b086f5745921"));
        checkpoints.put(  26000, Sha256Hash.wrap("00000002bace42e673000616ed8dbf16a49e3a7aec6bf59774fed081f6deac5f"));
        checkpoints.put(  29999, Sha256Hash.wrap("00000000ede644fcbdf8f8ce8c53bb15de5dfd5c32384c751fa4ef409992aa07"));
        checkpoints.put(  36222, Sha256Hash.wrap("0000000047c4338861a6b191570f07a23bd30c75c03a81ac5e5978053d946408"));
        checkpoints.put(  40599, Sha256Hash.wrap("00000000c2596d6bd49b08ab9d233cd7de97a01a7cde19d0e1a136a1f3904f3c"));
        checkpoints.put(  45512, Sha256Hash.wrap("00000000e2448d27f6360461739bcd25bf41d3767fc7c0e8c5e53a2db90eaf06"));
        checkpoints.put(  49478, Sha256Hash.wrap("00000000dbb3d6386ed45e335316a4f018e451bf60b12fdebbef680969a90acb"));
        checkpoints.put(  74910, Sha256Hash.wrap("000000002409374bcab8006f171b8c3eb4485220d94ae555b041ee24eb4d8434"));
        checkpoints.put(  84579, Sha256Hash.wrap("00000000372eebd8b26d135798ac04549dc32fdfb584710ed9edf2dcb1be6941"));
        checkpoints.put( 140602, Sha256Hash.wrap("0000000000b86fa0891a7241c71a0969439896b61abaf07e856eb0f49115b741"));
        checkpoints.put( 186158, Sha256Hash.wrap("0000000002d477cc1fea0438f7d477c0c993ae3762bc60efdbb8873275b385c7"));
        checkpoints.put( 212573, Sha256Hash.wrap("0000000da60270f8183780773064d689762b6ad6749296e9fc274c3dcecfc6f6"));
        checkpoints.put( 279122, Sha256Hash.wrap("00000002e14806c9d2aa7afeeb43df69b90ab8c6083b33b34fd9d62c57dac559"));
    }

    //
    // TestNet - NOT TESTED
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;
    public static final int testnetp2shHeader = 196;
    public static final long testnetPacketMagic = 0x4c1a2caf;
    public static final String testnetGenesisHash = "000008030a1e9a647ecc6119e0782166552e49dadfa8353afa26f3a6c2179845";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);
    static public long testnetGenesisBlockTime = 1402095180L;
    static public long testnetGenesisBlockNonce = (386986707);

    static public String[] testnetDnsSeeds = new String[] {
            "85.214.68.75",
    };

    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
