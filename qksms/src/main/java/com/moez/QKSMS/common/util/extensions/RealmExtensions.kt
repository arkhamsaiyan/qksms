package com.moez.QKSMS.common.util.extensions

import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults

fun RealmObject.insertOrUpdate() {
    val realm = Realm.getDefaultInstance()
    realm.executeTransaction { realm.insertOrUpdate(this) }
    realm.close()
}

fun <T : RealmObject> RealmObject.asObservable(): Observable<T> {
    return asFlowable<T>().toObservable()
}

fun <T : RealmObject> RealmResults<T>.asObservable(): Observable<RealmResults<T>> {
    return asFlowable().toObservable()
}