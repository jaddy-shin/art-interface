package me.jaddy.service

import me.jaddy.port.`in`.GetQueryResultUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class QueryResultService : GetQueryResultUseCase {
}