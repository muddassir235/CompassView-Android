# CompassView
A custom compass that shows the direction of a vector ahd can be scaled according to it's magnitude.

![](https://lh3.googleusercontent.com/GXpg43IybiB7L-hIk3V2ICWhRckb16rCWAB_eqID3L1FOXC3ikkDnsR9kyeyw9WLOesa4S-BfVG7PQ2EOId-evxfBhTkitsNDuOTZwWDr29CznH8qxzb7n7dy-H4GfiDNNFiyX_opgQkNTNqPJUi23OGFzH66ubd8X7vBx-hJeAWlXLr2WfKWRDROiK6rWm3wy130nLMpem9vo7eXII0blwvr2jtqO1IedBNcSgGRldd86Hj25t4wilgV_dUDUtIeeg_PuxdTwmyjSbz37iw8CdoONOf6UIYtgoqbDVfZXoxrBInUbgSMJgkXeAZn5t9TTpfnTZQmJ8Q6vgRN3jCbkmL3OLH19Ut6dV9SeRQv85A3jMTLtHy99mIeZq5F1WpNwPtJnKDujZeWSy0MKnTMw6VfRbgxq88QU74Z-2kII-9a3LWDP7qvgJSX09gMweRY47XgqddSPgiv4dn_qnZNGVG8Ly1X6LgHhFtTXlMkWGz2upNXRGiga38dm77P7JAtN-3VAsasLKP1fIbRT_6-BhrRB223UXJvQ2uoiJdhfFRD2i2G2z9zTJ-_mcy2ocSTOmzebVgNW3AWnygfZnn-6C9aHAt5q-bI3k1gZ4L8_y_xy8V=w345-h613-no)

![](https://lh3.googleusercontent.com/fZrv61sXolWy2jTFm_4m5WsladjIB1kxmZ9miI15VIT5Bvl60zayOg4BVCLR0wlDvvQZ0avKEiNpUhUxVTrvwVYzezQMsPeCt_1RVD2TayzM2ew0F-OCL-DVQdSBbmXCF1jDqkkiS9_QSS541QRhrLKiD1gtU44xrysdd-qYrulZkCLkfPSYPhVamLU6QduBSz5CAawUr5GuXnS4ra5kDlih11pljkE157Yt5VZZdgXt3Te5LWfOgk3jciknztZPnG4x-UJ1oSsBuiQs_dMxJERbay-MC2Slr0gVbCO3EfcaFRUrZJggUlTEf59GF9z7dSR0Hk2IaH1rM9d2huHlvkqquwKB2vsx8upihbAp0wLcZ5u76fCzBjYSGaFs5gNr7hsOntw4K9VXTy3Tknag4XOyvv3y1JY4DKR50VCETIOkxPqjzuh_Lhv3hBYyT1lrAp1ATuDRPPt59sOw7_igtp9bXWw300UZwvgqGJpo2BElmVfybXg-gLJLedPd-VaUV434tbqFEx4PsbrXk2rU5xpZq-p2ihqPtMn-MCpU4VvEFTLcToXByUIxWKXLq74cGL0ZmggEJ3F4Jx8AiEHgmW3daO9qi0z7pKEJWNuuYn03DC1S=w345-h613-no)

![](https://lh3.googleusercontent.com/ClLF357y1u8ZZJRryJGua6gmYzgIpd138BIPRC4SSO2QY8pBgIlC9S_c_ld7lW1sudmrVQEIn9iQE6skH-sxqB4x8TqupkuQORxJgQ3zuSZocD5NGlykGXPlzpZdD-5cg8h4y2nLphd97lZ-a1XjJL_HxY8eu7ekHua0EvYKnwdpw2sn7MFTsY0JQurramBpVxJxP9vF8lbpCUJWMmAk5tVO3sWX2ll4ZZIy5TfX_8YCA576paIRs2eazGMkEptI1ZJC538Z84uAS-vUsEENlqGfRsV1QRkD4ApvVfLaULjKmQe5RTgtDZb8Z3tLgqTAwXUSi3bqcuJtUKQd1hiZDzq4J0YqfsJh2m-oGTtWOoSaHOnHklB8C-IlquJKHPZijYuucKs7d3p5B-ajEOJx8_NyzZNslGr5mWBHYwWpN1DgcVcae44wNoLG3izACIVXXCdrfRvLvDbpL-H4ob3Ls1v3QimO0v4GDfnNsrihSbnZp6P9ummuqvgQ1rq8j0TTGuwANxLHc5zzzEzq9QhwZXc5PgS6ff0bHK40sNrxUpUdlto9pkHTbeo-M_YGzgbHqUBQ3g503mW5xiiKqdGdxRvM6hBkmc4Cs7RlgX1ueebwAaJQ=w345-h613-no)

It is similar to arrows shown in the google weather card.

![](https://github.com/muddassir235/CompassView/blob/master/google_weather_card.PNG?raw=true)

## Issues:

This custom view doesn't support resizing to more than 22dp x 22dp and doesn't support xml attributes yet.

## How to use:
adding compass to xml

```
 <com.example.hp.sunshine.Compass
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/wind_compass"/>
```

Find View in Java
```
Compass compass = (Compass) view.findViewById(R.id.wind_compass);
```

By default the compass is 22dp x 22dp which is it's full scale size and is at 0 degrees to North

```
compass.setAngle(windAngle); // @param: integer angle (N = 0, E = 90, S = 180, W = 270)
compass.setScale(windSpeed); // @param: float scale: e.g 0.45f (max upto 1.0f) otherwise the arrow will become bigger than the view bounds
```
set direction

## LICENSE:

Issued under Apache [license](https://github.com/muddassir235/CompassView/blob/master/license.txt) 2.0.

## How to contribute:

- `fork` this repo to your profile.
![](https://github.com/muddassir235/CompassView/blob/master/fork_icon.PNG?raw=true)
- `clone` it locally using the following command.

    `> git clone https://github.com/YOUR_USERNAME_HERE/CompassView`
- Edit the `CompassView.java` file as you wish.
- Run and Enjoy :-)
