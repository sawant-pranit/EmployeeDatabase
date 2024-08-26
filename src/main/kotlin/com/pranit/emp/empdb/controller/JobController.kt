package com.pranit.emp.empdb.controller

import com.pranit.emp.empdb.entity.Job
import com.pranit.emp.empdb.repository.JobRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jobs")
class JobController(private val jobRepository: JobRepository) {

    @GetMapping
    fun getAllJobs(): List<Job> = jobRepository.findAll()

    @GetMapping("/{id}")
    fun getJobById(@PathVariable id: Int): ResponseEntity<Job> =
        jobRepository.findById(id).map { job ->
            ResponseEntity.ok(job)
        }.orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun createJob(@RequestBody job: Job): Job =
        jobRepository.save(job)

    @PutMapping("/{id}")
    fun updateJob(@PathVariable id: Int, @RequestBody updatedJob: Job): ResponseEntity<Job> =
        jobRepository.findById(id).map { existingJob ->
            val jobToUpdate = existingJob.copy(
                jobTitle = updatedJob.jobTitle,
                minSalary = updatedJob.minSalary,
                maxSalary = updatedJob.maxSalary
            )
            ResponseEntity.ok(jobRepository.save(jobToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteJob(@PathVariable id: Int): ResponseEntity<Void> =
        jobRepository.findById(id).map { job ->
            jobRepository.delete(job)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())
}