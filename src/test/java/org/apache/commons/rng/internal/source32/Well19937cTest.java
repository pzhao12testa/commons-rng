/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.rng.internal.source32;

import org.apache.commons.rng.RandomAssert;
import org.junit.Test;

public class Well19937cTest {
    @Test
    public void testReferenceCode() {
        final int[] base = {
            0x2c2878c6, 0x47af36c4, 0xf422e677, 0xf08fd8d3, 0xee9a47c7, 0xba983942, 0xa2a9f9a5, 0x1d443748,
            0x8fc260b2, 0x5275c681, 0x4a2f5a28, 0x2911683d, 0xa204c27e, 0xb20a6a26, 0x54ba33be, 0x67d63eb0,
            0xdc8174cf, 0x3e73a4bc, 0x6fce0775, 0x9e6141fc, 0x5232218a, 0x0fa9e601, 0x0b6fdb4a, 0xf10a0a8c,
            0x97829dba, 0xc60b0778, 0x0566db41, 0x620807aa, 0x599b89c9, 0x1a34942b, 0x6baae3da, 0x4ba0b73d
        };
        final int[] init = new int[624];
        for (int i = 0; i < init.length; ++i) {
            init[i] = base[i % base.length] + i;
        }

        final Well19937c rng = new Well19937c(init);

        final int[] expectedSequence = {
            0x7edec319, 0x137f7bdc, 0x37c1c37b, 0xfb0d1dff, 0xc1f16ad5, 0x7c4068a8, 0xc0032722, 0x9bee9252, 0xe0c9f2cb, 0xa5b568ea, 0xd4158686, 0x5b0f0588, 0xc15788dd, 0x3a55d414, 0x187504f3, 0x66fc6017,
            0xd959cc8e, 0x25e97379, 0x747e1644, 0x010eeaba, 0xc6dc7c9f, 0xbef3f7ae, 0x6ae035d2, 0x9bd81a26, 0x6ad25d08, 0x38256124, 0x84d90476, 0xb59176cc, 0xc0bf323e, 0x0f9e1c5d, 0x4c1cddd9, 0xf20f2bc0,
            0x695a0d04, 0x94000049, 0xe7cb28ff, 0xd3bf53b0, 0xaf8bb19b, 0x0e532354, 0xec339ebf, 0x58bf7827, 0xec325ac8, 0x7cc5aa3d, 0x2837eb14, 0x8cf477fc, 0x0f5335ab, 0x03cd69f2, 0x8aea9f89, 0x4e6e43ad,
            0xd0796ae6, 0x51c765ea, 0xa975e2af, 0xb103fbf3, 0xcc1ebb29, 0xb2da48c7, 0x05740a3f, 0x17050574, 0xd608ac32, 0xb6a553e5, 0x5a38d698, 0xf052fef0, 0x47499f92, 0x536193f4, 0x2fe7ca52, 0x97a2fa11,
            0xb45f6e9c, 0x4985f38c, 0x594e74ce, 0xc625f3e7, 0x246cdac7, 0xf067ce26, 0x6d521aad, 0x65e3fdec, 0xf709204a, 0x7e65316b, 0xfc441a64, 0x1c8e2f2a, 0x5b80263a, 0x6cae8d07, 0xbcb0698f, 0xbeb89941,
            0x7cba00fd, 0x04b2f254, 0xd6c0aecf, 0x622d78dd, 0x91daf1d5, 0x6d91ea98, 0xcd6f73ef, 0xae08d95e, 0x36d9bb0d, 0x5a28e042, 0xd3547654, 0x113787ce, 0xe689290d, 0x28827f84, 0x195fadc8, 0x8429f741,
            0x8cff2aa9, 0xd96cdf1d, 0x26c4e246, 0x8d282435, 0xa2bbe3e7, 0x2bc77ef6, 0x0672e7cf, 0x0ead6d17, 0x30484504, 0x745e4f6b, 0x40ecb162, 0x9048d3fd, 0x5523f340, 0xe29de2f0, 0x73f279f2, 0xf400ee3e,
            0xd2f82235, 0xdac8031a, 0xd64cdd2d, 0xf93cf1b2, 0x3039c0e3, 0xa54f4589, 0x43bdb22d, 0xe0c9915c, 0x07ec53b1, 0x72d4f7e1, 0xa777e6eb, 0xe1b39d36, 0x02c299ac, 0x9efea144, 0xdcdead5a, 0x916676cc,
            0x22d3b419, 0x4bde036a, 0xdc66ccde, 0x37246ed1, 0x41b7d435, 0xd3190503, 0xff6eafee, 0x95fc3949, 0x21e9b23e, 0x2d8ee04e, 0x4b193a5c, 0x88c8851e, 0x4ded8ffd, 0xf6fa0e5e, 0x301e55c0, 0x76d63407,
            0xff13710a, 0xd5b652fc, 0x7d752882, 0x52b661db, 0x8d04f089, 0x0d5ddacc, 0xd446e69a, 0xcafbcf9e, 0x8984d559, 0xe5f1b626, 0x3b5c50d9, 0xc31ee252, 0xbea795d4, 0xc38d417d, 0xb251db7f, 0x47a34e74,
            0x9206e323, 0x54b9cbef, 0x3a75e8eb, 0x7fc75a73, 0x1caef0d8, 0x6ab98ab9, 0x1393b948, 0x76f65ee7, 0xfc06b913, 0xabdf6bad, 0xf2bb9912, 0x33ac9e6d, 0xed99663a, 0xc1836f53, 0x3b335f02, 0xbc182f96,
            0xcc08cf04, 0x44480a49, 0x16c3c484, 0x021bf543, 0x61cf1463, 0xb8e48de4, 0x2e4060c1, 0x236b7beb, 0x5f8edb74, 0xddb89132, 0x789eefd0, 0x9e7803b1, 0xd532c268, 0x9cac6c7d, 0x8014de6c, 0x131bdea2,
            0x1120b21a, 0x1b15981b, 0x42534699, 0x6861226b, 0x2e9d8fd6, 0xa7e0aef8, 0xc3f1e570, 0xcc9a1c03, 0x86aeeed0, 0x7e924572, 0xdec310e2, 0x954fcdfd, 0x346e3e41, 0x02a1f1b3, 0x2f27f9b8, 0x526dfc4b,
            0x80b40b77, 0x6ccec2ac, 0x37dec1cd, 0x92541501, 0xa4651211, 0xa83a3cc9, 0x5c45690c, 0xa84a250a, 0xff229d49, 0x59fafe96, 0x80befb64, 0xd10fed27, 0x3099205c, 0xec749098, 0x3d4782e1, 0x33abf36f,
            0xa177b36a, 0x3336cb98, 0x0dfedbfe, 0x3b842d28, 0x8ee07c01, 0xca4cff3d, 0x46532f70, 0x5b2b6c63, 0x24fbddda, 0x42bf598c, 0x630534bc, 0x7d03dad9, 0xaa51a19a, 0x0fd04003, 0xc54bebf9, 0x4f14a0e0,
            0x4c4bea10, 0x288b310d, 0x09491bb6, 0x5c71f942, 0xec94f643, 0xdc5e73af, 0xffe266bc, 0x502f465f, 0x73105451, 0x381d61e8, 0x27e4ba3d, 0x29584901, 0xc4f2ca16, 0x22bf6406, 0x3a2e99c9, 0x8f2bfeed,
            0xc08451b3, 0xd58fe12f, 0xd6ef140f, 0xc2d7155d, 0x427ad78b, 0xb22c2143, 0x98aaf5f3, 0xea452758, 0xfeb3f1dc, 0xfdc91816, 0xf06204ae, 0x4da5f8c0, 0x9455d83f, 0xd2476703, 0x2d8b6d09, 0x639bd681,
            0x6d883cee, 0xc31b85eb, 0x95ca6161, 0xf22a041d, 0xed7a716d, 0x93a20f80, 0xbcbf3170, 0xd5f1eaff, 0xeadf9724, 0xe0d10439, 0xe6238f2e, 0x07dcb3e5, 0xfc2afa24, 0x16c240a0, 0x0db2c767, 0x6b2b30ae,
            0x510ada0e, 0x3a52712b, 0xcb3be546, 0xab99bb22, 0xeabfb9e4, 0xc6b1e8c0, 0x738e42f2, 0x2a38792f, 0x287d4b71, 0x2c61ecd9, 0x4f340c96, 0x4af5475e, 0x21ed8d1a, 0xd3199ce9, 0xa5691a07, 0x783736e4,
            0x3f5747be, 0x5d163656, 0x78eaa4b7, 0xaf5ad571, 0x34d50980, 0x576fedd4, 0x633a961b, 0x4ce50eed, 0xfc92dd27, 0xb9e5f2d2, 0x6172d7dc, 0x75cc035b, 0x51e7aa25, 0xd9550b09, 0x3f127b7d, 0xc9d1bfd7,
            0xa50462ce, 0x2b4f72af, 0x7b2dc16a, 0x03df87cf, 0xfe70bacf, 0xcb323d1b, 0x936d66c0, 0xbe3673cf, 0x2b8c2aeb, 0xb106e415, 0xd67547f4, 0xb2764ee5, 0x45d4ddca, 0x2f850e32, 0xa0989ade, 0x72eeb982,
            0x124ef405, 0xa7a33538, 0x8f932ec8, 0x4dde9770, 0x73f27c3f, 0xb42d15a9, 0xb35970af, 0x85627333, 0x2f637629, 0x4b41467f, 0xb619b967, 0x5508d2e4, 0xd120ec59, 0x7e5fac94, 0x4beafa1c, 0x047021f5,
            0xc267a7cb, 0x14340175, 0x02bfc7ce, 0x490f54dd, 0x7e150a3a, 0x286c8609, 0x9f8b3ccb, 0xf9f861b7, 0x9ee7cb36, 0xb6845cb4, 0x1befeeb4, 0x6fd1c7ac, 0x0586d7b2, 0x0de95fef, 0xdeebf834, 0x024b5ff4,
            0xe7c64262, 0x7c301fc3, 0xbe065f69, 0xebb0fc83, 0x8166ddfc, 0x0d4d81ef, 0x067df564, 0xc385fd42, 0xca4692e0, 0xcdff7338, 0x8e3f341b, 0x96e2fe05, 0xc8c0c4af, 0x658dc9c9, 0xd832dbc7, 0x64fec5d5,
            0x2f2f7caf, 0x414ee5cd, 0x42b5aaf7, 0xab6a13f2, 0x880f5d3e, 0x0b34eb1f, 0x9631f705, 0x8a8367f3, 0x9b616dba, 0x07d61dad, 0xd1ba86c1, 0x5a15f6d4, 0x7c077a68, 0x98a7ef75, 0x76bdc227, 0x42bf3960,
            0x3f7fc05c, 0xaf149096, 0x1b98432f, 0x46605986, 0xf3eb5d4e, 0xcacb4b3d, 0x241cd50b, 0x4433f4af, 0x345c46d6, 0xc15558d9, 0x33ff625c, 0x25a1369f, 0xf5b65320, 0xa37d4531, 0x8c64828f, 0x090eecfd,
            0x61cd8d5e, 0x1284a410, 0x0209bde2, 0x7aa72267, 0x88861f85, 0x8ffd16c3, 0x22bbd8f2, 0x35adc920, 0xe68689af, 0xb68bda90, 0xe01ac730, 0x4ec9e07e, 0x0422c21c, 0x98ebd14e, 0x548c30f3, 0x3cebe0bb,
            0x1d9c8e39, 0xfb2fbd63, 0x8e8a3bf2, 0xbcb72a02, 0x001a001c, 0x76485181, 0x331106c2, 0xcf8bd670, 0x2e38fb73, 0xadfb0c7f, 0x2610b3e8, 0x12baf9d0, 0x3d6e1b9f, 0x26637035, 0x0467fd38, 0x1597cf95,
            0x0e19ffc8, 0x573748bb, 0xf2abea20, 0x19f33e4a, 0xd32e4e42, 0xf897b887, 0x8952556c, 0x5e27274b, 0x4a7be189, 0x0964a079, 0xeb6c3655, 0xea2b8aa9, 0xac8dc1ae, 0x6273663f, 0x7520a7a4, 0xbde674bf,
            0x455c8311, 0x673c6dd3, 0xa8e70ce1, 0x27eba8a0, 0xe3992185, 0xf03ad983, 0xfe0b4c83, 0x112debec, 0xfe77538a, 0x06520e54, 0x629c12ea, 0xea3c46c1, 0x78122826, 0x86613c06, 0x509060f0, 0xc92a48b3,
            0x8a8de595, 0xfd2e28dc, 0x0d4136c1, 0xea566c5b, 0xbeedb674, 0x7c9d545b, 0xb7379ebf, 0x98e7a5da, 0xb620278c, 0x3f79c6f6, 0xf9b726d9, 0xe6fc4389, 0x0473db65, 0xff3bba4d, 0xe24d016c, 0x5d64fb35,
            0x905ec12d, 0x5f2e9216, 0x1cf64a72, 0x1bf7d07d, 0xcb715b1f, 0x4df41208, 0x9e13c159, 0x52c37c45, 0x16a32dec, 0x414ecd38, 0x321d4bbc, 0x734c4436, 0x6e58440e, 0xaef95d11, 0x07cce4ea, 0xed5126a1,
            0xd871e390, 0x3d7eb569, 0xdbbbe3ed, 0xf3c5d9a5, 0x91c36995, 0x75a2a625, 0x3fb3b4b0, 0xab5282a7, 0x46db12c1, 0x38dd91a9, 0xc4aa9202, 0x93a1fa9c, 0x8c88a4e9, 0xeca7e496, 0xa55d6ce3, 0x222559d5,
            0xdeeef730, 0x3ead7cd9, 0xb5c8bb34, 0xc544c260, 0x13a107ce, 0x6a913618, 0xfdbf2ad8, 0x97230e9f, 0xa8c4dff7, 0x91084281, 0x4a9c79ce, 0x0f508c83, 0xd190d6ec, 0x85d11a18, 0x4add635d, 0x4932f289,
            0xa399e5c9, 0xdb8fffd3, 0x46fa1f63, 0x7a0bf590, 0xdda9c298, 0xa4a2aabd, 0xb107a3be, 0xf67ab868, 0xdae50206, 0xbf9be351, 0xf1ee6a34, 0x70f7207f, 0xe78e0257, 0x8c1e8fd3, 0xd75cd8e3, 0x4807878b,
            0x228bee66, 0x4db82643, 0xf7523656, 0xf8287153, 0x8db87ff9, 0x354cac8f, 0xf58733ea, 0xa17f7bed, 0x278f20b0, 0xbc0bf059, 0xd9c043b6, 0x5f223f88, 0x2580cb7d, 0x3a3305d6, 0xa264d169, 0x1f58f5c0,
            0x355951f8, 0xe1f34129, 0x5f8504bc, 0xb6811335, 0x94cd73ab, 0xa741d4d9, 0x3eedf6e3, 0x0f9bb6e7, 0x70037c6f, 0x1d19f627, 0x71e747d3, 0x8d97a695, 0x16146769, 0x4b69e106, 0xb2ea0bb4, 0xa6613f5d,
            0x7bcbf0db, 0xadc48b26, 0x44f7ed7b, 0x76487961, 0x8be65c2b, 0x65adaa3c, 0x56a449ec, 0xb677ffac, 0x5836265d, 0xcc8241bf, 0xcc9894f2, 0xd4167eb5, 0x380befb6, 0xa0def654, 0xb9f89a1f, 0xdb4ccc8c,
            0xcb3fdefb, 0x94e82e16, 0x6deba24f, 0xf4bcf81b, 0x7d9a1c63, 0x9c2218ec, 0xc3d4a196, 0xccc8adbc, 0xe6423bad, 0xff6d9cb7, 0x9001f125, 0xf9c00ee1, 0xa47e535e, 0xfbde542f, 0x22f82e52, 0xb2fa0fd4,
            0x522e0c10, 0xee01c885, 0xecf7e7e5, 0x63f8215b, 0x116e7113, 0xb324b06d, 0x6a947310, 0x71b3c33d, 0x574db9bb, 0xae3894ca, 0x8a0d69c3, 0x965d7648, 0x742d4770, 0x6c6167c7, 0xbc2af085, 0x4a7d548c,
            0xa81752ef, 0x90a8618f, 0xad792cd7, 0x2abcac40, 0x38dfc8ad, 0x8eb7bd70, 0x2c0429f5, 0xf6864304, 0x67495b70, 0x73657de6, 0xbc72610c, 0xba12e5b7, 0x55697d48, 0x32d231b1, 0x673d35b3, 0x92d121a8,
            0x4beeaf0b, 0x1b24e6d1, 0x76848372, 0x0658f61c, 0x1e2a5a78, 0xdb9c0b89, 0x65363d88, 0x4e2fad94, 0x75643b24, 0x8f7f9e81, 0x602cb6a1, 0x35d5be4e, 0xd4050f93, 0x136920e0, 0xb672a2d0, 0x58f06280,
            0x77cc0d9d, 0xea0cc233, 0x410c812d, 0x7bbee557, 0xc6b2512f, 0x6d6d42f8, 0x12d998c3, 0xcd232a71, 0x81504d3f, 0x309975b0, 0xd064afa5, 0xf692e014, 0x292c8f42, 0xe05d017c, 0x47bcd24c, 0x600d518e,
            0x9cf8dc52, 0xfcd47806, 0x7ebc9254, 0xf22891eb, 0x5cf3de69, 0x10e65bda, 0x47b0aae2, 0x378f642c, 0x40871560, 0xde04e735, 0x18a5a62f, 0xc4b11717, 0xc49af5b4, 0xfff7c080, 0xd3900171, 0xd58dacd3,
            0xc49dbeb9, 0xdcaac902, 0x70a4af34, 0x4e5ba48b, 0xe87ff6d2, 0xd754acdf, 0x1b34d507, 0x670b7caf, 0xe86140c2, 0xfd69f505, 0x722f8595, 0xcca56c00, 0xbfb42ec4, 0xde89b25f, 0x423f9a5c, 0x03cb2150,
            0x9b0996b3, 0xc647d8c4, 0xc13a3be4, 0x2a3f6a3e, 0x70448244, 0x16413317, 0xf6ad5dd1, 0xa0d7995c, 0x91eab041, 0x34f860b3, 0xc2de16b9, 0x9cab91e9, 0xeb8d3965, 0x85454198, 0x263c89bc, 0x98075f64,
            0x6244249f, 0x67ec4fb2, 0x78754956, 0x09c6a9a3, 0x3b09f4e6, 0x65b5b924, 0xb64cefde, 0xeb4f6d1c, 0x6de3a15b, 0x314eeb71, 0x11e991ad, 0xb48ac1d2, 0xdf61abb7, 0xdd3f2416, 0x89100beb, 0x291482fb,
            0xfa729f5f, 0x31caa8c0, 0x65b51953, 0xa047de5c, 0x0bfa540f, 0x19b1f7b8, 0xef74910c, 0xc8a86ac7, 0xdf15c2eb, 0x08ab20d5, 0x4349f2f3, 0x63d7ee22, 0x730ef44a, 0x4878641d, 0xa9b4c629, 0x2734df6a,
            0x70681724, 0x9ee3d02c, 0xcc35ad39, 0xb501da60, 0x6cf734a3, 0xcb518339, 0x1ba711d5, 0xeb4bb07a, 0x581a4528, 0x2fc0fd40, 0xa67a9505, 0x3ca34fc4, 0x9d6232ae, 0x076402a2, 0x5eb2f08a, 0x2f283ebb,
            0xa5373549, 0x144a431e, 0xe2686576, 0xb91672db, 0xff8f328c, 0x79e6d632, 0xb5c5383f, 0x31c1d79e, 0xafb83193, 0x793f92ae, 0x2bee63a2, 0x3592a67b, 0x763389bf, 0x92015d60, 0x00924224, 0xb9a158bd,
            0x633f6b3e, 0x74329dae, 0xf36aa400, 0x449f9207, 0x80e99a4d, 0x366d33a8, 0x83b87bd8, 0x54a16838, 0xbc603f96, 0xfcca8f1b, 0xf1486745, 0x1beaf2a2, 0x972079e5, 0x43c07483, 0x4de76d88, 0x86a088d9,
            0xafc425e8, 0x12c29942, 0x9bade757, 0xc78b9bb4, 0xf2055c60, 0x82a1aa6b, 0xef5ae0c2, 0xffe95a1f, 0xc12df407, 0x6b5c3697, 0x381f9756, 0xcbe5ffd1, 0xd7e4e45d, 0x2d6f88ad, 0xa6e47c25, 0x1d010c37,
            0xca7592bb, 0x99f7129b, 0xf35465a8, 0x7d8e6639, 0x9ffd595a, 0x509de716, 0xce107f7e, 0x5d7a1591, 0xdca73f0b, 0xbbad72d2, 0xa0e0cdd5, 0xd9ce71de, 0x42060b17, 0x5c375f25, 0x8d0f2c01, 0x8558e0fb,
            0x25d79b7e, 0x13a7ee4a, 0x3827dac6, 0xcc7a37b8, 0x1dea23ec, 0x5b9eeaec, 0xb9a1106c, 0x42f0773c, 0x410598db, 0x1922101e, 0x792ed235, 0x65fa8731, 0xbd5bc8fc, 0x046e0d7f, 0x0f568443, 0xb87a5ba7,
            0x0c6f614c, 0xe5a267b9, 0x302aeb8f, 0x458c5e43, 0x462df72d, 0x915d5116, 0xa8b05c54, 0xfc62efe5, 0xb224a7a2, 0xfa91da46, 0xaa7d6a0a, 0x20b789a9, 0x0239f034, 0x581cbd1f, 0xb5314846, 0x0ecf5a13,
            0xf9c347db, 0x90d3c58f, 0x548aaa17, 0x9d020ae5, 0x8119cd74, 0x0937343e, 0x107c35f4, 0x730ea08a, 0x0ab30092, 0xc89c15f9, 0xfda60285, 0xade29d38, 0x55f81711, 0x43cd0b96, 0xe63dc843, 0xc54d1d3d,
            0x2c4acb0c, 0xbd4f0a28, 0xca1c2b19, 0xb41d5405, 0x8fa83a6a, 0xd0209cdb, 0x4ac06696, 0xe322e653, 0x12eee7fc, 0x18184ffd, 0xb6ab3464, 0x42d7e76e, 0xfed40cdd, 0x26eb7cf1, 0xc117c59c, 0xe40c6141,
            0xa6fa7f07, 0xa9b701be, 0xae5c58b7, 0xa59469dc, 0xf74e7485, 0x5a7af0fe, 0x5ed7b77a, 0xa80cc8e6, 0xc9c6be0f, 0x7d5c0680, 0xe7c0420d, 0x8165f25a, 0x946ca3cd, 0xaf15ff66, 0x21d0a50d, 0x1861945c,
            0x21d804fc, 0x683fc3ea, 0x6911942a, 0x967aff93, 0x4bc411ec, 0x1be874d4, 0x38f83c15, 0x71f647e1, 0x6fd64938, 0xd5312075, 0xb3c5c7a9, 0x52fc8882, 0xf8d1045f, 0x32c07581, 0x0e9b3d22, 0xfe02d431,
            0xef051cf0, 0xe36ae0e0, 0xf357d93d, 0xf8ba290f, 0xa8e45921, 0x4f558f8a, 0x6a9c3399, 0x67a79778, 0x56359069, 0x89a8779f, 0x28dc5622, 0xad5caf9d, 0x518d9809, 0x788204a6, 0x5f2853bd, 0x99ae3972,
            0x88214ef7, 0x0a3e9f01, 0xed6e7113, 0x28ff2dd4, 0x167892d1, 0xc1159f83, 0xa6a6585e, 0x939ce279, 0xf8cbc44e, 0x0205172b, 0xad4c49e7, 0xdfb8bea4, 0x454bd571, 0xb0a436d6, 0x73238978, 0xcd51e8d0,
            0x27917ada, 0x5b951147, 0xecc08e55, 0xadbab7b5, 0x0f91729a, 0xf3c9dd44, 0x8288a531, 0x34ae0598, 0x094971cc, 0xa94eea2d, 0x4ee14e30, 0x9ae16080, 0x5c60135d, 0x3cafbe3f, 0xb0dcaa89, 0xa1ad4300,
            0x3c6b38a1, 0x937f826e, 0x6354c0e3, 0x53cfb25c, 0xf44903d6, 0x4a6a2603, 0xb577e6ff, 0x31da1546, 0x0a96ad06, 0x8d240123, 0x7fe78131, 0x291c2be0, 0xdc70841f, 0x14c2613f, 0x7242fe48, 0x1cb0ec08,
            0xebc0c66e, 0x48ada81f, 0x2ad97b0f, 0x8857a7c4, 0x912f1372, 0x79b8f601, 0xfc88c020, 0x2c40dff6, 0x7314fa94, 0x2e8a8d6f, 0x2a9ee539, 0xaceafc39, 0xff83a201, 0xdc42b76d, 0xdff9707f, 0xb7ba790c
        };

        RandomAssert.assertEquals(expectedSequence, rng);
    }
}
